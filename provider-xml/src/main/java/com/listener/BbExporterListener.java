package com.listener;

import com.alibaba.dubbo.rpc.Exporter;
import com.alibaba.dubbo.rpc.ExporterListener;
import com.alibaba.dubbo.rpc.RpcException;

/**
 * Created by ZhaGuolong on 2018/3/9.
 */
public class BbExporterListener implements ExporterListener {

    @Override
    public void exported(Exporter<?> exporter) throws RpcException {
        System.out.println("BB=====================================exported");

    }

    @Override
    public void unexported(Exporter<?> exporter) {
        System.out.println("BB=====================================unexported");
    }
}
