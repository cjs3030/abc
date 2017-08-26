import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @auther zhanghui
 * @date 2017/8/26 0:43
 * @desc
 */
public class Producer {
    public static void main(final String... args) throws Exception {
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring-context.xml");


        //RabbitMQ模板
        //RabbitTemplate template = ctx.getBean(RabbitTemplate.class);
        AmqpTemplate  template = ctx.getBean(AmqpTemplate.class);



        //发送消息
        try {
            template.convertAndSend("Hello, world!");
        }catch (Exception e){
            e.printStackTrace();
        }


        Thread.sleep(1000);// 休眠1秒
        //ctx.destroy(); //容器销毁
    }
}