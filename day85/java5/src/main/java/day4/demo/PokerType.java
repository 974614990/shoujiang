package day4.demo;
//管理牌的图案 和比较图案的大小
public class PokerType {
    private String pic ;//图案
    private int id;//大小

    //把图片固定
    public static final PokerType SPADES = new PokerType("♠",4);
    public static final PokerType HEARTS = new PokerType("♥",3);
    public static final PokerType CLUBS = new PokerType("♣",2);
    public static final PokerType DIAMONDS = new PokerType("♦",1);


    public PokerType(){}
    //提供一个自定义的构造方法
    //默认的构造方法就被屏蔽了
    public PokerType(String pic,int id){
        this.pic = pic;
        this.id = id ;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
