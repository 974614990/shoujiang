package day3;

import java.util.ArrayList;

public class PokerManager {

    //定义一个静态属性 保存所有点数
    public String [] dots ={"2","3","4","5","6","7","8","9","10","J","Q","K","A"};

    //保存所有花色
    public PokerType[] types ={PokerType.HEARTS,PokerType.DIAMONDS,PokerType.CLUBS,PokerType.DIAMONDS};
    //用数组管理一副牌
    public ArrayList<Poker> pokers = new ArrayList<>();

    //生成一幅牌
    public void initPokers(){
        //从点数数组里面依次读取每一个点数
        for(String dot:dots){
            //给当前这个点数配上花色o
            for(PokerType type:types){
                Poker poker = new Poker();

                //将这张牌保存起来


            }

        }
    }
    //显示所有的牌
    public void show(){
        for(Poker poker:pokers){
            //System.out.print(poker.number+poker.type.pic+" ");
        }
    }
}

