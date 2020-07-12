package day3;

public class Myclass {
    public static void main(String [] args){
        //欢迎界面
       Utils.showTest(true,"欢迎来到英雄联盟斗地主");

       // 创建poker管理器
        PokerManager manager = new PokerManager();

        //生成一副牌
        manager.initPokers();

        //输出一下
        System.out.println();


       String[] choices = {"看牌","弃牌","下注","加注"};
       Utils.showTest(choices);
    }
}
