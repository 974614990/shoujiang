package day13.day13media;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyClass {

}
//客户端
class Cilent{
    public static void main(String [] args) throws IOException {
        //连接服务器 获取socket
        Socket socket = new Socket("127.0.0.1",8080);

        //创建服务器端对应的输入流 用于接收服务器端发来的数据
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(br.readLine());

        //向服务器端发送文件（图片）
        //1、将文件写入内存
        String path = "C:/Users/asus/Desktop/1.jpg";
        FileInputStream fis = new FileInputStream(path);

        //2、创建字节流的outputStream
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        byte[] buf = new byte[1024];
        int len = -1;
        while ((len = fis.read(buf)) != -1){
            bos.write(buf, 0,len);
        }
        socket.shutdownOutput();
        /*
        //2、将内容输出到服务器端
        PrintStream ps = new PrintStream(socket.getOutputStream());

        //3、将文件的内容一点一点的传输给服务器
        byte [] buf = new byte[1024];
       int len = -1;
       while ((len = fis.read(buf)) != -1){
           ps.print(new String(buf,0,len));
        }

*/
    }
}
//服务器端
class Server{
    public static void main(String [] args) throws IOException {
        //创建服务器端的ServerSocket
        ServerSocket ss = new ServerSocket(8080);

        //监听客户端的连接的socket
        // 当有客户端来连接服务器得到对应的socket
        // 当没有客户端来连接 服务器一直在这里等待
        Socket socket = ss.accept();
        //创建客户端对应的输出流 用于向这个客户端发送数据
        PrintStream ps = new PrintStream( socket.getOutputStream());
        //
        ps.println("连接成功，可以发数据了！");

        //接收客户端传递过来的图片
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        //文件对应的输出流
        String path = "D:/Andriod/day85/java5/src/main/java/day13/day13media/1.jpg";
        FileOutputStream fos = new FileOutputStream(path);
        byte [] buf = new byte[1024];
        int len = -1;
        while ((len = bis.read(buf)) != -1){
            fos.write(buf,0,len);
        }

        /*
        String line = null;
        int len = -1;
        char[] buf = new char[1024];
        while ((len = br.read(buf)) != -1){
            //将字符数组转化为字符串
            line = new String(buf,0,len);
            //将字符串写入文件
            psFile.print(line);
        }

        */
    }
}