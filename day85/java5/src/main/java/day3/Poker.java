package day3;
// 3 4 5 6 7 8 9 10 J Q K A 2

/**
 * 花色
 * 1、输出 ♣Spades ♥ Hearts♠ Clues♦Diamonds
 * 2、比较 1 2 3 4
 */
public class Poker {
    String number;//保存点数
}
//管理花色
class PokerType{
    //黑桃的一个对象
    public static final PokerType SPADES = new PokerType("♠",4);//黑桃
    public static final PokerType HEARTS= new PokerType("♥",3);//红桃
    public static final PokerType CLUBS = new PokerType("♣",2);//梅花
    public static final PokerType DIAMONDS= new PokerType("♦",1);//方片

     public String pic; //记录图案
     public int id;  //用于比较

    //构造方法
    public PokerType(String pic,int id){
        this.pic = pic;
        this.id = id;
    }

}