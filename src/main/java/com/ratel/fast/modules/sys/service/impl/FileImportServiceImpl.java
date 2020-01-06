package com.ratel.fast.modules.sys.service.impl;


import com.ratel.fast.common.utils.R;
import com.ratel.fast.modules.sys.entity.SysFileImportEntity;
import com.ratel.fast.modules.sys.entity.SysFileImportTemplateDetailEntity;
import com.ratel.fast.modules.sys.service.*;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FileImportServiceImpl implements FileImportService {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    SysFileImportService sysFileImportService;

    @Autowired
    private SysFileImportTemplateService sysFileImportTemplateService;

    @Autowired
    SysFileImportTemplateDetailService sysFileImportTemplateDetailService;

    private Map<String,FileImportProcess> fileImportProcessMap;

    @PostConstruct
    private void init(){
        fileImportProcessMap=applicationContext.getBeansOfType(FileImportProcess.class);
    }

    public R readXlsToMap(SysFileImportEntity sysFileImportEntity){
        String filePath= sysFileImportEntity.getFilePath();
        List<Map<String,Object>> rst=new ArrayList<>();
        FileInputStream fis =null;
        Workbook wookbook = null;

        try {
            fis = new FileInputStream(filePath);
            wookbook = new HSSFWorkbook(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                fis=null;
            }
            return R.error(10030,e.getMessage());
        } catch (Exception e) {
            try {
                if(fis!=null){
                    try {
                        fis.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    fis=null;
                }
                fis = new FileInputStream(filePath);
                wookbook = new XSSFWorkbook(fis);
            } catch (Exception e1) {
                e1.printStackTrace();
                if(fis!=null){
                    try {
                        fis.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    fis=null;
                }
                return R.error(10020,"file not xls/xlsx format");
            }
        }
        Sheet sheet = wookbook.getSheetAt(0);
        Row rowHead = sheet.getRow(0);

        /**
         * 验证
         */
        Map<String,Object> valiParam=new HashMap<String,Object>();
        valiParam.put("rowHead",rowHead);
        R valiRst=this.validationFile(sysFileImportEntity.getTemplateName(),valiParam);
       // if(!valiRst.isOk()){
         //   return valiRst;
        //}

        int headNum=rowHead.getLastCellNum();
        int totalRowNum = sheet.getLastRowNum();
        Map<String,Object> currMap=null;
        boolean isAddRow=false;
        for(int i = 1 ; i <= totalRowNum ; i++) {
            //获得第i行对象
            Row row = sheet.getRow(i);
            if(row == null){
                continue;
            }
            currMap=new HashMap<String,Object>();
            for(int j=0;j<headNum;j++){
                Cell currCell=row.getCell(j);
                if(currCell != null){
                    currCell.setCellType(CellType.STRING);
                }
                if(!StringUtils.isEmpty(currCell) && !(currCell+"").equals("")){
                    isAddRow=true;
                }
                currMap.put(String.valueOf(rowHead.getCell(j)),currCell);
            }
            if(isAddRow){
                rst.add(currMap);
                isAddRow=false;
            }
        }

        return  R.ok().put("data",rst);
    }

    protected R validationFile(String template,Map<String,Object> fileInfo) {
       // List<SysFileImportTemplateDetailEntity> sysFileImportTemplateDetailEntityList= sysFileImportTemplateDetailService.selectList(new EntityWrapper<SysFileImportTemplateDetailEntity>().eq("template_name",template).orderBy("order_by"));
        List<SysFileImportTemplateDetailEntity> sysFileImportTemplateDetailEntityList= new ArrayList<>();
        Row rowHead= (Row) fileInfo.get("rowHead");
        int configCount=sysFileImportTemplateDetailEntityList.size();
        //未校验数量
        int actualNum=rowHead.getLastCellNum();
        //去掉空表头
        for (int i = 0; i < actualNum; i++) {
            if (rowHead.getCell(i).getStringCellValue().isEmpty()) {
                rowHead.removeCell(rowHead.getCell(i));
            }
        }
        int actual=rowHead.getPhysicalNumberOfCells();
//        if(configCount!=0 && configCount!=actual){
        if(configCount!=actual){
            return R.error(10050,"表头格式错误");
        }
//        if(configCount!=0){
            int count=0;
            for(SysFileImportTemplateDetailEntity sysFileImportTemplateDetailEntity:sysFileImportTemplateDetailEntityList){
                if (rowHead.getCell(count)==null || rowHead.getCell(count).getStringCellValue().isEmpty()) {
                    continue;
                }
                if(!sysFileImportTemplateDetailEntity.getFieldName().equals(rowHead.getCell(count).getStringCellValue())){
                    return R.error(10050,"表头格式错误:"+rowHead.getCell(count).getStringCellValue());
                }
                count++;
            }
//        }

        return R.ok();
    }

    @Override
    public R process(Map<String,Object> paramData, String templateName) {
        Integer count = sysFileImportTemplateService.getCountByTem(templateName);
        List<String> fileIds= (List<String>) paramData.get("fileIds");
        List<R> rst=new ArrayList<>();
        for(String fileId:fileIds){
            if(count==0){
                continue;
            }
           // SysFileImportEntity sysFileImportEntity= sysFileImportService.selectById(fileId);
           SysFileImportEntity sysFileImportEntity= new SysFileImportEntity();

            String filePath=sysFileImportEntity.getFilePath();

            if(!filePath.endsWith(".xls")&&!filePath.endsWith(".xlsx"))
            {
                rst.add(R.error(10010,"Error file format"));
                continue;
            }
            R fileRst=readXlsToMap(sysFileImportEntity);
            if(!String.valueOf(fileRst.get("code")).equals("0")){
                rst.add(fileRst);
                continue;
            }
            List<Map<String,Object>> fileData= (List<Map<String, Object>>) fileRst.get("data");
            Map<String,Object> param=new HashMap<>();
            param.put("fileData",fileData);
            param.put("fileMetaData", objToMap(sysFileImportEntity));
            param.put("metaParam",paramData.get("metaParam"));
            R currR=R.error(10020,"file not process");
            for(FileImportProcess fileImportProcess:fileImportProcessMap.values()){
                if(fileImportProcess.support(templateName)){
                    currR=fileImportProcess.process(param);
                }
            }
            rst.add(currR);
        }
        return R.ok().put("data",rst);
    }

    public Map objToMap(Object obj){
        try {
            return BeanUtils.describe(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
