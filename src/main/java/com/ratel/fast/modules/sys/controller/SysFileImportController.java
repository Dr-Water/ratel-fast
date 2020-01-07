package com.ratel.fast.modules.sys.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ZipUtil;

import com.ratel.fast.common.utils.PageUtils;
import com.ratel.fast.common.utils.R;
import com.ratel.fast.modules.sys.entity.SysFileImportEntity;
import com.ratel.fast.modules.sys.entity.SysUserEntity;
import com.ratel.fast.modules.sys.service.FileImportService;
import com.ratel.fast.modules.sys.service.SysFileImportService;
import com.ratel.fast.modules.sys.service.SysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.*;


/**
 * 文件导入
 *
 * @author bpms
 * @email bpms@lenovo.com
 * @date 2019-02-18 19:18:03
 */
@RestController
@RequestMapping("sys/files")
public class SysFileImportController   extends AbstractController {
    @Autowired
    private SysFileImportService sysFileImportService;
    @Autowired
    FileImportService fileImportService;
    @Autowired
    SysUserService sysUserService;

    @Value("${import.localFilePath}")
    private String localFilePath;

    @Value("${import.zipDownloadBasePath}")
    private String zipDownloadBasePath;


    /**
     * @param files 文件数组
     * @param templateName 上传的文件所属的模块
     * @return
     * @throws IOException
     */
    @PostMapping("/upload/{templateName}")
    public R uploadfiles(@RequestParam("file") MultipartFile[] files, @PathVariable("templateName") String templateName) throws IOException {
        SysUserEntity sysUserEntity = getUser();
        ArrayList<String> fileIds = new ArrayList<>();
        String filePath=localFilePath+templateName+ File.separator;
        //循环保存文件到服务器
        for (MultipartFile file : files) {
            String fileName = UUID.randomUUID().toString().replace("-","");
            String originalFilename = file.getOriginalFilename();
            String extName = originalFilename.substring(originalFilename.lastIndexOf("."));
            //将文件上传到指定位置（关键一步）
            file.transferTo(new File(filePath+fileName+extName));
            SysFileImportEntity sysFileImportEntity=new SysFileImportEntity();
            sysFileImportEntity.setFileExt(extName);
            sysFileImportEntity.setFilePath(filePath+fileName+extName);
            sysFileImportEntity.setFileName(fileName);
            sysFileImportEntity.setFileSize(file.getSize()+"");
            sysFileImportEntity.setTemplateName(templateName);
            sysFileImportEntity.setUploadStatus("1");
            sysFileImportEntity.setUploadStatus("1");
            sysFileImportEntity.setCreaterId(sysUserEntity.getUserId().intValue());
            sysFileImportEntity.setCreaterItcode(sysUserEntity.getUsername());
            sysFileImportEntity.setCreaterName(sysUserEntity.getUsername());
            sysFileImportEntity.setOrginFileName(originalFilename);
           sysFileImportService.save(sysFileImportEntity);
            fileIds.add(sysFileImportEntity.getId()+"");
        }
        //返回文件的id
        return R.ok().put("fileids", fileIds);
    }


    /**
     * @param files 文件数组
     * @param templateName 上传的文件所属的模块
     * @return
     * @throws IOException
     */
    @PostMapping("/upload2/{templateName}")
    public R uploadfiles2(@RequestPart("file") MultipartFile[] files, @PathVariable("templateName") String templateName) throws IOException {
        SysUserEntity sysUserEntity = getUser();
        ArrayList<String> fileIds = new ArrayList<>();
        String filePath=localFilePath+templateName+ File.separator;
        //循环保存文件到服务器
        for (MultipartFile file : files) {
            String fileName = UUID.randomUUID().toString().replace("-","");
            String originalFilename = file.getOriginalFilename();
            String extName = originalFilename.substring(originalFilename.lastIndexOf("."));
            //将文件上传到指定位置（关键一步）
            file.transferTo(new File(filePath+fileName+extName));
            SysFileImportEntity sysFileImportEntity=new SysFileImportEntity();
            sysFileImportEntity.setFileExt(extName);
            sysFileImportEntity.setFilePath(filePath+fileName+extName);
            sysFileImportEntity.setFileName(fileName);
            sysFileImportEntity.setFileSize(file.getSize()+"");
            sysFileImportEntity.setTemplateName(templateName);
            sysFileImportEntity.setUploadStatus("1");
            sysFileImportEntity.setUploadStatus("1");
            sysFileImportEntity.setCreaterId(sysUserEntity.getUserId().intValue());
            sysFileImportEntity.setCreaterItcode(sysUserEntity.getUsername());
            sysFileImportEntity.setCreaterName(sysUserEntity.getUsername());
            sysFileImportEntity.setOrginFileName(originalFilename);
            sysFileImportService.save(sysFileImportEntity);
            fileIds.add(sysFileImportEntity.getId()+"");
        }
        //返回文件的id
        return R.ok().put("fileids", fileIds);
    }

    @RequestMapping("/downloadFile/{id}")
    public ResponseEntity<InputStreamResource> downFile(@PathVariable("id") String id) throws Exception{
        SysFileImportEntity sysFileImportEntity=sysFileImportService.getById(id);
       // SysFileImportEntity sysFileImportEntity=new SysFileImportEntity();
        //文件下载统计
//        sysStatisticalDataService.setStatisticalFileData(sysFileImportEntity);
        if(sysFileImportEntity!=null){
            String fileName=sysFileImportEntity.getOrginFileName();
            String filePath=sysFileImportEntity.getFilePath();
            File file = new File(filePath);
            InputStream inputStream = new FileInputStream(file);
            InputStreamResource inputStreamResource = new InputStreamResource(inputStream);
            HttpHeaders headers = new HttpHeaders();
            if(sysFileImportEntity.getTemplateName().equals("solutionAudioUploadList")){
                headers.add("Accept-Ranges", "bytes");
            }
            headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
            headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", URLEncoder.encode(fileName,"UTF-8")));
            headers.add("Pragma", "no-cache");
            headers.add("Expires", "0");
            return ResponseEntity
                    .ok()
                    .headers(headers)
                    .contentLength(file.length())
                    .contentType(MediaType.parseMediaType("application/octet-stream"))
                    .body(inputStreamResource);
        }else {
            InputStream inputStream = new ByteArrayInputStream("<script language=\"javascript\">alert('文件不存在！');</script>".getBytes("GBK"));
            InputStreamResource inputStreamResource = new InputStreamResource(inputStream);
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE,"text/html;charset=UTF-8");
            headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
            headers.add("Pragma", "no-cache");
            headers.add("Expires", "0");
            return ResponseEntity
                    .ok()
                    .headers(headers)
                    .contentType(MediaType.TEXT_HTML)
                    .body(inputStreamResource);
        }
    }

    /**
     * 获取文件列表
     */
    @RequestMapping("/getFiles")
    public R getFiles(@RequestParam Map<String, Object> params){
        List<SysFileImportEntity> sysFileImportEntities = sysFileImportService.getFiles(params);

        return R.ok().put("sysFileImportEntities", sysFileImportEntities);
    }




    /**
     * 下载文件
     * @throws IOException
     * @return
     */
    @RequestMapping("solutionInfoFilesDownload")
    public ResponseEntity<InputStreamResource> solutionInfoFilesDownload(@RequestBody List<Integer> fileIds) throws IOException {

        long fileEX = System.currentTimeMillis();
        String zipName= "solutionInfoFiles"+fileEX+".rar";
        String tempSrc=zipDownloadBasePath+fileEX+File.separator;

        List<SysFileImportEntity> solutionInfoFiles = new ArrayList<>();
        // 1. 获取解决方案和成功案例的附件
        if (fileIds != null && fileIds.size()>0) {
            for (Integer fileId : fileIds) {
               // SysFileImportEntity sysFileImportEntity = sysFileImportService.selectById(fileId);
                SysFileImportEntity sysFileImportEntity = new SysFileImportEntity();

                solutionInfoFiles.add(sysFileImportEntity);
            }
        }
        //2. 拷贝临时文件
        if (solutionInfoFiles != null && solutionInfoFiles.size()>0) {
                for (SysFileImportEntity solutionInfoFile : solutionInfoFiles) {
                    FileUtil.copy(solutionInfoFile.getFilePath(), tempSrc+solutionInfoFile.getOrginFileName(),true);
                }

            // 3. 打压缩包
            File zipForOutPut = ZipUtil.zip(tempSrc,zipDownloadBasePath+zipName);
            InputStreamResource inputStreamResource = new InputStreamResource(new FileInputStream(zipForOutPut));
            // 4.删除除压缩包以外的临时文件
            FileUtil.del(new File(tempSrc));
            HttpHeaders headers = new HttpHeaders();
            headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
            headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", URLEncoder.encode("solutionInfoFiles.rar","UTF-8")));
            headers.add("Pragma", "no-cache");
            headers.add("Expires", "0");
            return ResponseEntity
                    .ok()
                    .headers(headers)
                    .contentLength(zipForOutPut.length())
                    .contentType(MediaType.parseMediaType("application/octet-stream"))
                    .body(inputStreamResource);
        }else {
            InputStream inputStream = new ByteArrayInputStream("<script language=\"javascript\">alert('文件不存在！');</script>".getBytes("GBK"));
            InputStreamResource inputStreamResource = new InputStreamResource(inputStream);
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE,"text/html;charset=UTF-8");
            headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
            headers.add("Pragma", "no-cache");
            headers.add("Expires", "0");
            return ResponseEntity
                    .ok()
                    .headers(headers)
                    .contentType(MediaType.TEXT_HTML)
                    .body(inputStreamResource);
        }
    }
}
