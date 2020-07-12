package day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Client {
    public static void main(String [] args){
        BufferedReader br = null;
        PrintStream ps = null;
        BufferedReader brSever = null;
        //连接服务器
        try {
            Socket socket = new Socket("10.129.14.97",8888);
            //接收终端的输入流
            br = new BufferedReader(new InputStreamReader(System.in));
            //接收服务器端的输出流
            ps = new PrintStream(socket.getOutputStream());
            //接收服务器端的输入流
            brSever = new BufferedReader( new InputStreamReader(socket.getInputStream()));

            //登录
            while (true){
                //接收终端输入信息
                /*
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String line = br.readLine();
                */
                String line =  JOptionPane.showInputDialog("请输入用户名：");
                //拼接登录格式
                String loginStr = ChatProtocol.LOGIN_FLAG +line +ChatProtocol.LOGIN_FLAG;

                ps.println(loginStr);

                String result = brSever.readLine();

                //判断登录结果
                if(result.equals(ChatProtocol.SUCCESS)){
                    break;
                }else{
                    System.out.println("用户名已存在，请重新登录");
                }
            }

            //登录成功
            //开启线程处理服务器端的输入
            new ClientThread(socket).start();

            //接收终端输入 发送给服务器端
            String line ;
            while ((line = br.readLine()) != null){
                ps.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class ClientThread extends Thread{
     private Socket socket;
     public ClientThread(Socket socket){
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
            System.out.println("网络出错!");
        }finally {
            try {
                if (br != null){
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