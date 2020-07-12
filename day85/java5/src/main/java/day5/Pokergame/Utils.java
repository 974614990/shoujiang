package day5.Pokergame;

public class Utils {
    //如果不需要保存数据 没有成员变量
    //提供静态方法 访问方便
    public static void showText(boolean hasStar,boolean lineBreak,String...contents){
      //判断是否需要显示分割线
       System.out.print(hasStar?"******************\n":"");
       //判断输出的内容是多行还是一行
        if(contents.length == 1){
            System.out.print(contents[0]);
            //有分割线的时候需要换行
       //  System.out.print(hasStar?"\n":"");
        }else {
            //输出带编号的多行数据
            for(int i = 0;i < contents.length;i++){
                System.out.println((i+1)+"、"+contents[i]);
            }
        }
       System.out.print(hasStar?"\n******************\n":"");

        //判断是否需要换行
        System.out.print(lineBreak?"\n":"");
       /**
        if (hasStar){
            System.out.println("*****************");
        }
        */

    }
}
