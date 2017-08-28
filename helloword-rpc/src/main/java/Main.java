import java.util.Date;

/**
 * @auther zhanghui
 * @date 2017/8/25 16:53
 * @desc
 */
public class Main {
    public static void main(String[] args) throws Exception{
        RPCClient fibonacciRpc = new RPCClient();

        System.out.println(" [x] Requesting fib(30)");
        System.out.println(new Date());
        String response = fibonacciRpc.call("30");
        System.out.println(" [.] Got '" + response + "'");
        System.out.println(new Date());


        fibonacciRpc.close();
    }
}
