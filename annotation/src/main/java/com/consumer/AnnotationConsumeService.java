package com.consumer;

import com.provider.AnnotateService;

/**
 * Created by Star on 2018/2/24.
 */
public class AnnotationConsumeService {
    @com.alibaba.dubbo.config.annotation.Reference
    public AnnotateService annotateService;
}
