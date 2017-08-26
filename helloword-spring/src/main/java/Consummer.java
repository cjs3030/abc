import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * @auther zhanghui
 * @date 2017/8/26 0:45
 * @desc
 */
public class Consummer implements MessageListener {

    public void onMessage(Message message) {
        System.out.println("Consummer接收："+message.toString());
    }
}
