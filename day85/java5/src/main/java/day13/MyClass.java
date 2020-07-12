package day13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

/**
 *网络编程：
 * 在两台不同的计算机之间传递数据
 * 1、QQ聊天
 * 2、打开网易APP刷新界面  就有数据
 * 3、打开浏览器 浏览相应的网页  www.baidu.com
 *
 * 客户端  APP 浏览器 桌面QQ 用户用的东西
 * 服务器端  存储/处理数据的地方
 *
 *
 * URL：统一的资源定位
 * http://www.baidu.com/search?code =android
 * http/https ：传输协议  实现TCP/IP
 *www.baidu.com :域名 表示一台网络中的电脑
 *              IPV4  ipv6地址：唯一标识一台网络中的计算机
 *              32位：四个部分 每个是8个字节
 *              如IP地址：192.168.3.5  <->www.swu.com域名
 *  DNS服务器：域名解析
 *  将www.baidu.com类型的域名解析为对应的IP地址
 *
 *  search ：对应的后台程序文件 PHP Java写
 *  ？：表示运行这个程序需要传递的参数
 *  code =android  code是服务器端规定的字段
 *  &如果有多个参数使用&符号链接
 *
 *  IP地址：唯一标识某一台电脑
 *  IP地址只能找到这台电脑
 *  端口号：表示这台电脑上的程序
 *  端口号：唯一标识电脑上的某一进程（程序）
 *
 *  数据传输：TCP/IP协议
 *  TCP：面向连接的 安全的 类似于打电话  如果
 *  UDP：面向无连接的 不安全 但快 类似于飞鸽传书
 *
 *  网络中的数据传输：Socket实现 -> 套接字
 *  Socket类：客户端
 *  ServerSocket：服务器端
 *  两者不能单独使用
 *
 *  读取数据：服务器读取  客户端读取 BufferedReader->inputStreamReader ->socket.getInputStream
 *              终端读取：BufferedReader->inputStreamReader ->System.in
 *   输出：客户端输出 服务器端输出
 *          BufferedWriter -> OutputStreamWriter -> socket.getOutputStream
 *          PrintStream -> socket.getOutputStream
 *
 */
public class MyClass {
    public static void main(String[] args){

    }
}

//模拟客户端
class Cilent{
    public static void main(String [] args) throws IOException {
     /*1、创建用于通讯的socket
        指明和谁通讯：IP地址 端口号
      */
     Socket socket = new Socket("127.0.0.1",8989);
     //接收服务器端的数据
     //InputStream inputStream = socket.getInputStream();
     BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

     String line = null;
     while((line = br.readLine()) != null){
         System.out.println(line);
        }

     //向服务器端发送数据
    // socket.getOutputStream();

        //客户端向服务器端发送数据
        PrintStream ps = new PrintStream(socket.getOutputStream());
     ps.println("你好");
     socket.shutdownOutput();
    }
}
//模拟服务器端
class Server{
    public static void main(String [] args)throws IOException{
        // 1、创建服务器端的ServerSocket
        ServerSocket ss = new ServerSocket(8989);

        //2、获取连接的客户端的socket
        Socket clientSocket = ss.accept();

        //3、向客户端发送数据
        //或者 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        PrintStream ps = new PrintStream(clientSocket.getOutputStream());
        ps.println("登陆成功");

        //输出完毕
        clientSocket.shutdownOutput();

        //4、接收客户端发来的数据
        BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String line = null;
        while ((line = br.readLine()) != null){
            System.out.println(line);
        }
    }
}

/*
    手动输入内容  发送
    socket 扮演的客户端
    ServerSocket 扮演的是服务器端

    客户端 1、文本  2、图片 3、视频 4、      服务器端：
 */

//客户端
class MyClient{
    public static void main(String [] args){
        //连接服务器端的Socket
        Socket socket = null;
        try {
             socket = new Socket("127.0.0.1",8888);

             //接受服务器端信息
            //从键盘输入数据 发送给服务器端
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = null;
            //打印相应数据
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("网络出错，请重新登录");
        }finally {
            //出现错误就关闭连接
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

//服务器端
class MyServer{
    public static void main(String [] args){

        //创建ServerSocket
        try ( ServerSocket ss = new ServerSocket(8888)){
            //监听客户端的连接
            Socket socket = ss.accept();

            //从终端接收数据
            BufferedReader keyin = new BufferedReader(new InputStreamReader(System.in));
            //获取向客户端输出数据的输出流
            PrintStream ps = new PrintStream(socket.getOutputStream());
            String line = null;
            while ((line = keyin.readLine()) != null){
                //发送给客户端
                ps.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}