package day4.demo;


/**
 * 管理玩家的信息
 */
public class Player {
    public String name;
    public int id;
    public int money;
    public Poker poker;
    public  boolean hasDiscard;//是否已经弃牌

    //构造方法无参
    public Player(){

    }
    //有参构造方法
    public  Player(String name,int id,int money){
        this.name= name;
        this.id= id;
        this.money = money;

        }
        @Override
        //当打印一个对象的时候 就会默认去调用toString方法
        //如果当前里面没有实现这个方法 就到父类里面去查找
        //object里面默认实现就是打印对象的首地址
        public String toString(){
            //1号玩家： 张家辉 金币 1000

        return id+"号玩家:"+"  "+name+" "+"筹码:"+money + " "+getPokerString();
        }
        public String getPokerString(){
            String pkString = "";
            if(poker != null){
                pkString = " " + poker.getDot() + poker.getType().getPic();
            }
            return pkString;
        }
    /**
     *  打底  & 下注
     * @param count 下注金额
     *
     * @return -1：失败 > 0 成功
     */
    public int bet(int count){
        //判断自己的金币是否大于下注金额
        if(money >= count){
            money -=count;
            return count;
        }else {
            return  -1;
        }
    }

}
