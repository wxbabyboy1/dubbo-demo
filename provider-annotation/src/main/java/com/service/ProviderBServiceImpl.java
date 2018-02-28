package com.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.service.bean.HiParam;

/**
 * Created by ZhaGuolong on 2018/2/28.
 */
@Service(version = "1.0.2", mock = "true")
public class ProviderBServiceImpl implements ProviderBService {
    @Override
    public HiParam getHiParam(String name) {
        HiParam param = new HiParam();
        param.setName(name);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return param;
    }
}
