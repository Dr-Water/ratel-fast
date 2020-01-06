package com.ratel.fast.modules.sys.service;



import com.ratel.fast.common.utils.R;

import java.util.Map;

public interface FileImportService {

    public R process(Map<String, Object> param, String templateName);
}
