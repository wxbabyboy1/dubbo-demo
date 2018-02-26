package com.alibaba.dubbo.merger;

import com.alibaba.dubbo.rpc.cluster.Merger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Star on 2018/2/25.
 */
public class MyMerger implements Merger<List<Integer>> {


    //将每个group都调用一次,结果存到lists数组里面,数组每个参数类型就是提供者接口的返回类型
    public List<Integer> merge(List<Integer>[] lists) {
        List<Integer> list = new ArrayList<Integer>();
        for(int  i=0;i<lists.length;i++){
            System.out.println(lists[i]);
            list.addAll(lists[i]);
        }
        return list;
    }
}
