import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @auther zhanghui
 * @date 2017/8/25 9:28
 * @desc
 */
public class Recv {

    private final static String QUEUE_NAME = "zhanghui";

    public static void main(String[] argv) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("172.16.16.218");
        factory.setPort(5672);
        factory.setUsername("aps");
        factory.setPassword("aps");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,AMQP.BasicProperties properties, byte[] body)  throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + message + "'");

                //模拟消费端挂掉或处理长任务：现象，新的消息不这里不会消费，仅在首次启动的时候消费一个消息

                //模拟业务报错
                //int a=100/0;

                //模拟 长任务
                try {
                    Thread.sleep(20000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        //第二个参数  autoAck：
        // true  :我认为是服务器自动确认
        //false : 我认为是需要 显示确认
        //这个地方貌似跟 官方文档描述的不太一样 ，看源码 注视应该是我理解的意思
        //如果autoAck设置为false,那么如果有14个消息，会显示 未确认，会被一个一个消费掉（慢慢的，因为我线程等待20秒）；但是一直会有14个消息是未确认状态
        //这时候关闭消费端，修改成true，重启启动，这14个消息会再次被消费。
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}
