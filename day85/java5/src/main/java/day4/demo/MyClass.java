package day4.demo;

import com.sun.org.apache.bcel.internal.classfile.PMGClass;

public class MyClass {
    public static void main(String[] args){
        Utils.showText(true,true,new String []{"欢迎参加扑克游戏!"});

        //生成一副牌
        PokerManager.manager.deal();

        //显示一张牌
        PokerManager.manager.show();

        //提示输入玩家人数
        Utils.showText(false,false,new String[]{ "请输入参与人数:"});
        //接收
        int count = Utils.getInput();

        //初始化玩家信息
        PlayerManager.manager.initPlayer(count);
        //显示玩家信息
        //PlayerManager.manager.show();

        //开始游戏
        GameCenter gameCenter = new GameCenter();
        gameCenter.start();
    }
}
