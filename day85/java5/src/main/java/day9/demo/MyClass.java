package day9.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class MyClass {
    public static void main(String[] args) throws IOException {

        /**System.out.println("请输入密码：");
        Scanner scanner = new Scanner(System.in);
        //把输入的密码转换成字节类型

        //创建一个文件 并且给出完整路径
        String path = "/Andriod/day85/java5/src/main/java/day9";
        File file = new File(path.concat("/2.txt"));

        //判断文件是否存在
        if(file.exists() == false){
            //不存在就去创建
            file.createNewFile();
        }
        //向文件写入密码
        FileOutputStream fos = new FileOutputStream(file);
        byte[] password ={} ;
        fos.write(password);
        fos.close();
         */


        boolean logined =false;

        //判断是否已经登录
        String password = FileOperation.instance.password;
        if (password != null){
            logined = true;
        }

        //提示用户操作
        String alert;
        if (logined) {
            alert = "请输入密码";
        } else {
            alert = "请设置密码";
        }
        System.out.println(alert);

        String firt = null;
        int wrongTime = 3;
        while (wrongTime > 0) {
            //接收用户输入
            Scanner scanner = new Scanner(System.in);
            String inputPassword = scanner.next();

            //判断操作
            if (logined) {
                //已经登陆过 直接比较
                if (password.equals(inputPassword)) {
                    System.out.println("解锁成功");
                    break;
                } else {
                    System.out.println("解锁失败 请重新输入");
                    wrongTime--;
                }
            }else{
                //没有登陆过 在设置密码
                //判断是设置密码的第一次还是第二次
                if (firt == null){
                    //第一次  保存第一次输入的密码
                    firt = inputPassword;
                    System.out.println("请确认密码 ");
                }else{
                    //第二次 比较两次输入的密码是否相同
                    if (firt.equals(inputPassword)){
                        System.out.println("设置密码成功");
                        //保存设置的密码
                        FileOperation.instance.save(firt);
                        break;
                    }else{
                        System.out.println("两次密码不一致 请重新设置密码:");
                        firt = null;
                        wrongTime--;
                    }
                }


            }
            scanner.nextLine();
        }

    }
}
/**
 * 图案解锁
 *
 * 文件写入 文件读取
 *
 * 第一次运行：
 * 设置密码：6位
 *      从终端一次输入一个整数
 * 确认密码
 *
 * 设置过了 3次错误的机会
 * 检查密码:相同提示解锁成功  不同就提示密码不一致 重新输入
 */