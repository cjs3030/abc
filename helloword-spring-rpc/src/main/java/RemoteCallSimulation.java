/**
 * @auther zhanghui
 * @date 2017/8/26 23:35
 * @desc
 */
public class RemoteCallSimulation {
    public void process (String  foo) throws Exception{
        System.out.println("远程方法被调用："+foo);
        System.out.println("远程方法开始执行...");
        Thread.sleep(30000);  //远程暂停30秒，模拟很久
        System.out.println("远程方法结束执行...");
    }
}
