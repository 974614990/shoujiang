package day14.demo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import jdk.net.Sockets;

public class Server {
    //用于保存每一个用户对应的姓名和socket
    public static UserManager manager = new UserManager();

    public static void main(String [] agrs){
        //创建ServerSocket

        try {
            ServerSocket ss = new ServerSocket(8888);
            //监听所有来连接的客户端
            while (true){
                Socket socket = ss.accept();

                //让子线程处理这个socket

            }
        } catch (IOException e) {
            e.printStackTrace();
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
        PrintStream ps = null;
        try {
            //得到对应的输入流对象
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //得到对应的输出流对象
            ps = new PrintStream(socket.getOutputStream());

            String line = null;
            while ((line = br.readLine()) != null){
                //判断是不是登录
                if(line.startsWith(ChatProtocol.LOGIN_FLAG) &&line.endsWith(ChatProtocol.LOGIN_FLAG)){
                    //获取名字
                    String  name = line.substring(2,line.length()-2);

                    //判断这个用户是否已经登录
                    if(Server.manager.isLogined(name)){
                        //登录过了 发送结果给客户端
                        ps.println(ChatProtocol.FAILUER);
                    }else {
                        //没有登录
                        // 保存当前登录的用户信息
                        Server.manager.save(name,socket);

                        //发送结果给客户端
                        ps.println(ChatProtocol.SUCCESS);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
