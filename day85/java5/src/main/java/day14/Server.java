package day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

//服务器端
public class Server {
    //用于保存每一个用户对应的姓名和socket
    public static UserManager manager = new UserManager();
    public static void main(String[] args){
        //创建ServerSocket
        try {
            ServerSocket ss = new ServerSocket(8888);

            //监听所有来连接的客户端
            while (true){
                Socket socket = ss.accept();

                //让子线程处理这个socket
                new ServerThread(socket).start();
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
        try {//登录
            //1.得到对应的输入流
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //得到对应的输出流
            ps = new PrintStream(socket.getOutputStream());
            String line = null;
            while ((line = br .readLine()) != null){
                //登录 u+.....u+
                if(line.startsWith(ChatProtocol.LOGIN_FLAG) &&line.endsWith(ChatProtocol.LOGIN_FLAG)){
                    /*
                    String [] items = line.substring(2).split("u+");
                    String name = items[0];
                    */
                    //获取名字
                    String name = line.substring(2,line.length()-2);

                    //判断这个用户是否已经登录
                    if(Server.manager.isLogined(name)){
                        //登录过了
                        ps.println(ChatProtocol.FAILUER);
                    }else {
                        //没有登录
                        //保存当前登录的用户信息
                        Server.manager.save(name,socket);
                        //发送登录信息
                        ps.println(ChatProtocol.SUCCESS);
                    }
                }
                //判断是不是私聊
                else if(line.startsWith(ChatProtocol.PRIVATE_FLAG) && line.endsWith(ChatProtocol.PRIVATE_FLAG)){
                    // p+ jack♥ +hellop+
                    //获取信息
                    String msg = line.substring(2,line.length()-2);
                    //分割
                    String[] items = msg.split(ChatProtocol.SPLIT_FLAG);
                    //用户名
                    String name = items[0];
                    //聊天内容
                    String message = items[1];
                    //通过用户名 找到对应的socket
                    Socket desSocket = Server.manager.socketByName(name);
                    PrintStream desPs = new PrintStream(desSocket.getOutputStream());

                    //获取当前用户地名称
                    String currentName = Server.manager.nameBySocket(desSocket);

                    //发送私聊消息
                    desPs.println(currentName +"向你发送消息："+message);
                }else {
                    //群聊
                    //处理数据
                    String msg = line.substring(2,line.length() -2);
                    //获取当前用户名称
                    String currentName = Server.manager.nameBySocket(socket);

                    //遍历所有的用户信息
                    Collection<Socket> sockets = Server.manager.allUsers();
                    for(Socket s : sockets){
                        PrintStream tempps = new PrintStream(s.getOutputStream());
                        tempps.println(currentName+"发来群聊:" +line);
                        tempps.close();
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        // 私聊
        //   群聊

    }
}
