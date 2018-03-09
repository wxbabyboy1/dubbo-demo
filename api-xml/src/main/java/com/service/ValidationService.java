package com.service;


import com.service.bean.ValidationParameter;

import javax.validation.constraints.NotNull;

/**
 * Created by Star on 2018/2/25.
 */
public interface ValidationService { // 缺省可按服务接口区分验证场景，如：@NotNull(groups = ValidationService.class)
    @interface Save{} // 与方法同名接口，首字母大写，用于区分验证场景，如：@NotNull(groups = ValidationService.Save.class)，可选
    void save(@NotNull ValidationParameter parameter);
    void update(ValidationParameter parameter);
}
