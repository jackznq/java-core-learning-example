package org.javacore.rocketmq;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * @author dddd
 * @description 消息生产者
 * @date 2016-04-07
 */
@Slf4j
public class Producer {

    /*
     * Constructs a client instance with your account for accessing DefaultMQProducer
     */
    private static DefaultMQProducer producer = new DefaultMQProducer("ProducerGroupName");
    private static int initialState = 0;

    private Producer() {

    }

    public static DefaultMQProducer getDefaultMQProducer() {
        if (producer == null) {
            producer = new DefaultMQProducer("ProducerGroupName");
        }

        if (initialState == 0) {
            producer.setNamesrvAddr("47.244.128.241:9876");
            try {
                producer.start();
            } catch (MQClientException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return null;
            }

            initialState = 1;
        }

        return producer;
    }

    public static void main(String[] args) {
        sendMsg();
    }

    public static void sendMsg() {

        // 获取消息生产者
        DefaultMQProducer producer = Producer.getDefaultMQProducer();

        try {
            for (int i = 0; i < 2000; i++) {
                Message msg = new Message(
                    "TopicTest1",                   // topic
                    "TagA",                         // tag
                    "OrderID00" + i,                  // key
                    ("Hello MetaQ" + i).getBytes());  // body
                SendResult sendResult = producer.send(msg);
                System.out.println("sendResult:{}" + JSON.toJSONString(sendResult));
            }
        } catch (MQClientException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (RemotingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MQBrokerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        producer.shutdown();
    }

}
