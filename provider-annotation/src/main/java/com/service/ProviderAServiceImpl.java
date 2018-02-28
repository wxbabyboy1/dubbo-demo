package com.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.service.bean.HiParam;

/**
 * Created by ZhaGuolong on 2018/2/28.
 */
@Service(version = "1.0.1")
public class ProviderAServiceImpl implements ProviderAService {
    public String getName(HiParam param){
        return param.getName();
    }
}
