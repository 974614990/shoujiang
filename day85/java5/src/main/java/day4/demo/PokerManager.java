package day4.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * 管理牌的相关操作
 * 生成一幅牌 洗牌 发牌 牌的比较
 */
public class PokerManager {
    //保存一副牌
   private ArrayList<Poker> pokers = new ArrayList<>();

   //创建静态变量 单例对象通过manager访问
    public static final PokerManager manager = new PokerManager();
   //私有化构造方法
    private PokerManager(){

    }
    //定义一个方法生成一副牌
    public void deal(){
        //遍历整个点数的数组
        for(int i = 0; i < Constant.DOTS.length;i++){
            //获取对应的点数
            String dot = Constant.DOTS[i];

            //生成4种花色

            for(int j = 0;j < Constant.TYPES.length; j++){
                //创建一张牌
                Poker poker = new Poker(dot,Constant.TYPES[j]);
                //将这张牌保存起来
                pokers.add(poker);
            }
            //黑桃
            //默认构造方法
            /**
            PokerType spades = new PokerType();
            spades.setPic("♠");
            spades.setId(4);


            PokerType spades = new PokerType("♠",4);
            PokerType hearts = new PokerType("♥",3);
            PokerType clubs = new PokerType("♣",2);
            PokerType diamonds = new PokerType("♦",1);
             */
            //创建4张牌
            /**
            Poker ps = new Poker();
            ps.setDot(dot);
            ps.setType(spades);


            Poker ps =new Poker(dot,spades);
            Poker ph =new Poker(dot,hearts);
            Poker pc =new Poker(dot,clubs);
            Poker pd =new Poker(dot,diamonds);

            //加到数组里面去
            pokers.add(ps);
            pokers.add(ph);
            pokers.add(pc);
            pokers.add(pd);
             */
        }
        //洗牌
        Collections.shuffle(pokers);

    }
    //显示一张牌
    public void show(){
        for(Poker poker:pokers){
            System.out.print(poker.getDot()+poker.getType().getPic()+" ");
        }
        System.out.println();
    }

    /**
     * 给每个玩家发牌
     *
     * @param players 所有参与玩家
     */
    public void dealCards(ArrayList<Player> players) {
        for (int i = 0;i < players.size();i++){
            Player player = players.get(i);

            //将数组里面对应的扑克牌给对应的玩家
            player.poker = pokers.get(i);
        }
    }
}

