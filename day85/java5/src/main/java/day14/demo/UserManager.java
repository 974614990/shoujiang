package day14.demo;

import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class UserManager {
    //保存所有用户信息
    private Map<String, Socket> users = new HashMap<>();

    //判断用户是否登录
    public boolean isLogined(String name){
        //遍历数组
        for(String key :users.keySet()){
            if(key.equals(name)){
                return true;
            }
        }
        return false;
    }

    //保存当前登录的用户信息
    public void save(String name,Socket socket){
        users.put(name,socket);
    }

    //通过用户名来找对应的socket
    public Socket socketByName(String name){
        return users.get(name);
    }

    //通过socket对象找到对应的名称
    public String nameBySocket(Socket socket){
        for(String key: users.keySet()){
            //取出这个key对应的socket
            if(socket == users.get(key)){
                return key;
            }
        }
        return null;
    }
    //获取所有人的socket对象
    public synchronized Collection<Socket> allUsers(){
        return users.values();
    }
}
