package day13.group;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MyClass {
}
/*
    1、如何实现群聊
        在服务器端维护一个数组 【socket】
    2、私聊
    3、给每个人取名字


 */

//服务器端
class Server{
    //保存每一个连接过来的socket对象
    public static ArrayList<Socket> sockets = new ArrayList<>();
    public static void main(String [] args) throws IOException {
        ServerSocket ss = new ServerSocket(8888);

        //不停地等待客户端连接
        while (true){
            Socket socket = ss.accept();
            //当有客户端连接过来了 就保存
            sockets.add(socket);

            //开启一个线程处理每个客户端的输入
            new ServerThread(socket).start();
        }
    }
}

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
                //群发消息
                // 遍历Server维护的数组
                for(Socket s :Server.sockets){
                    //向socket对应的客户端发送消息
                    PrintStream ps = new PrintStream(s.getOutputStream());
                    ps.println(line);
                }
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


class Client{
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("10.129.14.97",8888);


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