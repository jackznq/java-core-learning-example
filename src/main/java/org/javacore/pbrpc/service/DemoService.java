package org.javacore.pbrpc.service;

import org.javacore.pbrpc.PbRpcDemo;

/**
 * /**
 * ClassName: DemoService <br/>
 * Function: demo服务端接口
 *
 * Created by ddfhznq on 2018/1/10.
 */
public interface DemoService {
    /**
     * 干点什么
     *
     * @param req
     *            请求
     * @return 响应
     */
    PbRpcDemo.DemoResponse doSmth(PbRpcDemo.DemoRequest req);

    /**
     * 用于测试批量干点什么
     *
     * @param req
     *            请求
     * @return 响应
     */
    PbRpcDemo.DemoBatchResponse doSmthBatch(PbRpcDemo.DemoBatchRequest req);

    /**
     * 干点什么，内部sleep一定时间，模拟超时
     *
     * @param req
     *            请求
     * @return 响应
     */
    PbRpcDemo.DemoResponse doSmthTimeout(PbRpcDemo.DemoRequest req);

}
