package day12;

public class Agent extends Thread{
    AgentInterface target;//回调给谁

    @Override
    public void run() {
        System.out.println("开始找房子");
        System.out.println("。。。。。");
        System.out.println("房子找到了，即将返回数据");

        target.callBack("房子在西南大学");//回调
        super.run();
    }
    public interface AgentInterface{
        void callBack(String dsc);
    }
}
