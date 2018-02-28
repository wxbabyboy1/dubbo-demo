package com.service;

import com.service.bean.HiParam;

/**
 * Created by Star on 2018/2/28.
 */
public class ProviderBServiceMock implements ProviderBService {
    @Override
    public HiParam getHiParam(String name) {
        HiParam param = new HiParam();
        param.setName("容错");
        return param;
    }
}
