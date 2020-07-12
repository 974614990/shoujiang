package day13.multiThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyClass {
}
/*
    客户端和服务器端都可以随意地发送内容
    从终端输入

    对聊
    客户端：
           主线程： 接收终端输入 将终端的输入发送给终端服务器
           子线程： 接收服务器发过来的数据

     服务端：
           主线程： 接收终端输入  将终端输入发送给客户端
           子线程：接收客户端发来的数据

 */

class Client{
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8888);


        //用一个子线程处理服务器端数据
        new Thread(new ClientThread(socket)).start();
        //主线程处理终端输入 发送给服务器端
        BufferedReader keyin = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream ps = new PrintStream(socket.getOutputStream());
        String line = null;
        while ((line = keyin.readLine()) != null){
            ps.println(line);
        }
    }
}

/*
    创建一个子线程处理客户端接收服务器数据

 */
class  ClientThread implements Runnable{
    private Socket socket;

    //保存操作的socket对象
    public ClientThread(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        BufferedReader br = null;
        try {
            //获取服务器端的输入流对象
             br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //读取数据
            String line = null;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("网络错误 请重新登陆");
            System.exit(-1);
        }finally {//出现异常，所有的资源都应该关闭 先关小的
            try {
                    if(br != null){
                    br.close();
                    }
                    if(socket == null){
                        socket.close();
                    }
            } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
class Server{
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8888);

        //获取客户端的Socket
        Socket socket = ss.accept();

        //创建子线程 处理客户端输入信息
        new ServerThread(socket).start();

        //终端输入流对象
        BufferedReader keyin = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        //客户端的输出流
        PrintStream ps = new PrintStream(socket.getOutputStream());

        //读取终端的输入 将输入输出给客户端
        String line = null;
        while ((line = keyin.readLine()) != null){
            ps.println(line);
        }
    }
}
/*
    创建一个子线程处理服务器端接收客户端的数据
 */
class ServerThread extends Thread{
    private Socket socket;
    public ServerThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader br = null;
        try {
             br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = null;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("网络异常 请重新登陆");
            System.exit(-1);
        }finally {
            //关闭输入输出流
            // 关闭对应的socket连接
            try {
                if(br != null) {
                br.close();
                }
                if(socket != null){
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
