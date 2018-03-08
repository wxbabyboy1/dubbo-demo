package com.group;


import com.service.GroupDemoService;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Star on 2018/2/25.
 */
public class GroupDemoService2Impl implements GroupDemoService {
    public List<Integer> sayGroup() {
        System.out.println("调用第二个");
        List<Integer> list = Arrays.asList(2,4,6);
        return list;
    }
}
