package swu.ht.java.java5;

import java.util.Scanner;
import java.util.Random;
/**
 * 杀人游戏
 * 1、输入参与人数：7
 * 编号
 * 输入死亡号码：3
 * 输出死亡顺序
 */
public class MyClass {
    public static void main(String[] args){
        int num = 0;

        //创建一个Scanner对象 用于接收终端的输入
   Scanner scanner = new Scanner(System.in);
        //提示输入参与人数
   System.out.print("请输入参与人数：");
   num = scanner.nextInt();
   //定义一个数组保存所有的编号
   int[] temp =new int [num];
   //开始编号
        for (int i = 0; i < num; i++){
            temp[i] = i+1;
        }
        //提示输入死亡号码
        System.out.print("请输入死亡编号：");
        int killedNumber = scanner.nextInt();
        //开始游戏
        int killed = -1;
        int count = 0;
        int totalKilled = 0;
        for(int i = 0; i< num ;i++){
            //判断i指向的那个人是否已经死亡
            if(temp[i] !=killed){
                //这个人报数
                count++;
                //判断是不是死亡号码
                if(count == killedNumber ){
                    System.out.println(temp[i]);
                    count = 0;
                    //杀掉这个人
                    temp[i] = killed;
                    //杀人总数加一
                    totalKilled++;
                    //判断是不是还剩一个
                    if(totalKilled ==num-1){
                        break;
                    }
                }
            }
            //判断是不是最后一个
            if(i== num-1){
                i= -1;
            }
        }
        //输出数组
        for(int i = 0 ;i < num ;i++){
            System.out.print(temp[i]+" ");
        }
    }
}
class Killman{
    public static void main(String[] args){
        int num = 0;
        //创建一个Scanner对象 用于接收终端的输入
        Scanner scanner= new Scanner(System.in);
        //提示输入参与的人数
        System.out.println("请输入参与人数：");
        num = scanner.nextInt();

        //定义数组保存所有的编号
        int []temp = new int [num];
        //开始编号
        for(int i = 0;i<num ; i++){
            temp[i]=i+1;
        }
        //提示输入死亡号码
        System.out.println("请输入死亡编号：");
        int killedNumber = scanner.nextInt();
        int killed =-1;
        int count = 0;
        int totalKilled = 0;

        //开始游戏
        for(int i = 0;i < num ;i++){
            //判断i指向的这个人是都已经死亡
            if(temp [i] !=killed) {
            //这个人报数
                count ++;
                //判断报的这个是不是死亡编号
                if(count == killedNumber){
                    System.out.println(temp[i]);

                    count = 0;
                    //杀掉这个人
                    temp[i] = killed;

                    //杀人总数+1
                    totalKilled++;
                    //判断是不是还剩一个
                    if(totalKilled == num -1){
                        break;
                    }
                }
            }
            //判断是不是最后一个
            if(i == num -1){
                i=-1;
            }
        }
        for(int i =0 ; i < num ;i++){
            System.out.print(temp[i]+ " ");
        }
    }
}

/**
 * ctrl + P  （proview）  光标移到上一行
 * ctrl+N(next)光标到下一行
 * ctrl+B(back)光标向左移动一个字符
 * ctrl+F （forward）光标向右移动一个字符
 * ctrl + A （ahead）光标跳到行首
 * ctrl +E （end）光标跳到行尾
 * ctrl +W 将当前窗口最大化
 */
class Test1{
    public static void main(String[] args){

    }
}