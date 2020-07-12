package day4.demo;


public class Constant {
    //用数组保存牌的点数  static final相当于定义常量
    public static final String [] DOTS = {"2","3","4","5","6","7","8","9","10","J","Q","K","A",};

    //保存固定的几个花色 黑红梅方
    public static final PokerType[] TYPES = {PokerType.SPADES,PokerType.HEARTS,PokerType.CLUBS,PokerType.DIAMONDS};

    //保存默认的玩家姓名
    public static final String[] DEFAULT_NAME= {"刘德华","周润发","张家辉","周星驰"};

    //设置默认的金币
    public static final int MONEY = 1000;

    //每局消耗的金币数 底注
    public static final  int  BASE = 10;
}
