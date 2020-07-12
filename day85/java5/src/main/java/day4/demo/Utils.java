package day4.demo;

import java.util.Scanner;

public class Utils {
    //如果不需要保存数据 没有成员变量
    //提供静态方法访问方便
    public static void showText(boolean hasStar,boolean lineBreak,String...contents){
        //三目运算符

        //判断是否需要显示分割线
        System.out.println(hasStar?"*******************":" ");
        //判断输出的内容是多行还是一行
        if(contents.length == 1){
            System.out.print(contents[0]);
                //有分割线的 时候换行
            System.out.print(hasStar?"\n":" ");

        }else {
            //输出带编号的多行数据
            //1、看牌
            for(int i = 0; i <contents.length;i++){
                System.out.println((i+1) +". "+ contents[i]);
            }
        }
        System.out.print(hasStar?"*******************\n":" ");
        //判断是否需要换行
        System.out.print(lineBreak?"\n":" ");
        // if(hasStar){
        //   System.out.println("******************");
        //}
        //if(hasStar){
        //  System.out.println("******************");
        //}

    }

    //接收用户的输入
    public static int getInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
