import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @auther zhanghui
 * @date 2017/8/26 0:43
 * @desc
 */
public class ActiveApp {
    public static void main(final String... args) throws Exception {
        System.out.println("ActiveApp main 启动");
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring-context.xml");


        AmqpTemplate  template = ctx.getBean("amqpTemplateActive",AmqpTemplate.class);
        //AmqpTemplate  template = ctx.getBean(AmqpTemplate.class);
        //发送消息
        try {
            template.convertAndSend("Tell me the result!");
            System.out.println("主动应用 已经 调用被动应用，请耐心等待返回结果。。。");
        }catch (Exception e){
            e.printStackTrace();
        }

        Thread.sleep(1000);// 休眠1秒
        //ctx.destroy(); //容器销毁
    }

    public void onMessage(String foo) {
        System.out.println("主动方接受到反馈结果："+foo);
        System.out.println("远程调用结束");
    }
}