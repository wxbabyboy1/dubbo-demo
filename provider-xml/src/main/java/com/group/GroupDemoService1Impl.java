package com.group;


import com.service.GroupDemoService;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Star on 2018/2/25.
 */
public class GroupDemoService1Impl implements GroupDemoService {
    public List<Integer> sayGroup() {
        System.out.println("调用第一个");
        List<Integer> list = Arrays.asList(1,3,5);
        return list;
    }
}
