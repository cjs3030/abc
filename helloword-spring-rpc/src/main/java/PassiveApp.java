import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @auther zhanghui
 * @date 2017/8/26 11:45
 * @desc
 */
public class PassiveApp {
    public void onMessage(String foo) {
        System.out.println("被动方接受到消息："+foo);
        //这里模拟调用远程方法
        RemoteCallSimulation remoteCallSimulation=new RemoteCallSimulation();
        try {
            remoteCallSimulation.process(foo);
        }catch (Exception e){
            e.printStackTrace();
        }

        //调用结束、推送返回结果
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
        AmqpTemplate template = ctx.getBean("amqpTemplatePassive",AmqpTemplate.class);

        //发送消息
        try {
            template.convertAndSend("The RemoteCall returns success!So I can tell you the result now!");
        }catch (Exception e){
            e.printStackTrace();
        }

        //Thread.sleep(1000);// 休眠1秒
        //ctx.destroy(); //容器销毁
    }
}