import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @auther zhanghui
 * @date 2017/8/25 9:18
 * @desc
 */
public class Send {

    private final static String QUEUE_NAME = "zhanghui";

    /*
    mq.host=172.16.16.218
    mq.username=aps
    mq.password=aps
    mq.port=5672
    mq.vhost=/
    */

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("172.16.16.218");
        factory.setPort(5672);
        factory.setUsername("aps");
        factory.setPassword("aps");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "Hello World!Work Queues!";
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");

        channel.close();
        connection.close();
    }
}
