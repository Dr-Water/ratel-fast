package com.ratel.fast.modules.sys.service.impl;


import com.ratel.fast.common.utils.R;
import com.ratel.fast.modules.sys.service.FileImportProcess;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DefaultDemandManageFileImportProcess implements FileImportProcess {


    @Override
    public R process(Map<String, Object> map) {
        return null;
    }

    @Override
    public boolean support(String templateName) {
        return false;
    }
}
