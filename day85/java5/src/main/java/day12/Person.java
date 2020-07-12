package day12;

public class Person implements Agent.AgentInterface {
    public void needHouse(){
        Agent xw = new Agent();
        xw.target = this ;
        xw.start();
    }
    @Override
    public void callBack(String dsc) {
        System.out.println("我是小王：接收到你的数据了："+ dsc);
    }
}
