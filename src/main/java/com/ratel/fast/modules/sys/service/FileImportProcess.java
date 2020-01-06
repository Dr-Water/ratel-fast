package com.ratel.fast.modules.sys.service;



import com.ratel.fast.common.utils.R;

import java.util.Map;

public interface FileImportProcess {

     R process(Map<String, Object> map);
     boolean support(String templateName);
}
