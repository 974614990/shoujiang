package day14.demo;

public interface ChatProtocol {
    //登录
    String LOGIN_FLAG = "u+";
    //私聊
    String PRIVATE_FLAG = "p+";
    //群聊
    String PUBLIC_FLAG = "a+";

    //分隔符
    String SPLIT_FLAG = "♥";

    //成功与否的状态
    String SUCCESS = "1";
    String FAILUER = "-1";

}
