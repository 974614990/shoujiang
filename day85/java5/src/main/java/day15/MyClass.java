package day15;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.InflaterOutputStream;

import javax.print.DocFlavor;

public class MyClass {
    /*
        URL的组成 ：网络地址
        http协议
        默认80端口号
        http://www.baidu.com/download/images/1.jpg

        http://www.baidu.com/download?t1=


        c/s模式：customer客户端 / server 服务器端

          移动端：APP   Java—Android
                        OC--ios
                        swift
                        Kotlin
          浏览器：火狐 IE Google
                    HTML(H5):超文本的标记语言
                    css
                    javaScript  (js脚本语言)

          服务器端：提供数据存储和访问的

          API :应用程序接口 Application Programming Interface


          如果需要将自己本地的数据提供给外部访问
          自己的电脑扮演的就是服务器端
          需要自己配置一个服务器 Apache服务器

          Windows必须自己搭建服务器 ：Apache Tomcat
          Mac： sudo apachectl  start /stop

          1.启动服务器
          2.找到服务器的工作路径
          Windows：Apache --Apache - htdocs
          3、将需要提供给外部访问的文件方法当前目录下（工作路径）
          4、如何访问：
                    本机访问：本机的具体地址IP地址  127.0.0.1/test.html
                    其他电脑（在同一个网段 局域网）：才能访问，非局域网就不能访问

        表单form：用于浏览器向服务器提交数据登录
        当表单提交之后 需要有一个东西能来处理这个表单
        后台语言：能够处理客户端的请求  Java PHP
        服务器端需要一个文件来处理用户登录的请求


     */
    public static void main(String [] args) throws IOException {

       /* Socket socket = new Socket("127.0.0.1",80);
        //传递的数据
        String data = "user_name=jack&user_password=123";

        //创建输出流
        PrintStream ps = new PrintStream(socket.getOutputStream());
        ps.println(data);

        //接收服务器端返回的结果
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(br.readLine());

        */

       /*
       //使用代码访问（提交、下载）服务器数据
        //使用URL
        //http://127.0.0.1/login.php?n=jack&p=123
        //1、创建URL
        String path = "http://127.0.0.1/login.php?"+"user_name=jack&user_password=123";
        URL url = new URL(path);


        //获取连接的对象
        // URLconnection封装了Socket
        URLConnection connection = url.openConnection();

        //2、指明请求的方式，默认是get
        HttpURLConnection httpConnection =(HttpURLConnection)connection;
        httpConnection.setRequestMethod("get");

        //判断连接状态
        //接收服务器端的数据 BufferedReader 读取较快
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        System.out.println(br.readLine());

        */
       getImage();
    }

    //使用post 上传简单数据（不是文件）
    public static void post() throws IOException {

        //1、创建URL
        URL url = new URL("http://127.0.0.1/login.php");

        //2、获取connection对象
        // URLConnection
        // HTTPURLConnection自己需要设定请求的内容 请求方式 上传的内容
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        //3、设置请求方式为post
        connection.setRequestMethod("POST");

        //4、准备上传数据
        String data ="user_name =jack &user_password = 123";

        //5、开始上传  输出流对象
        OutputStream os = connection.getOutputStream();
        os.write(data.getBytes());
        os.flush();

        //6、接收服务器端返回的数据
        InputStream is = connection.getInputStream();
        byte[] buf = new byte[1024];
        int len;
        while ((len = is.read(buf)) != -1){
            System.out.println(is.read(buf,0,len));
        }
    }


    //下载数据  get不带参数
    public static void getImage() throws IOException{
        //URL
        URL url = new URL("http://127.0.0.1/1.jpg");

        //获取与服务器连接的对象
        URLConnection connection = url.openConnection();

        //读取下载的内容 获取输入流
        InputStream is = connection.getInputStream();

        //创建文件保存的位置
        FileOutputStream fos = new FileOutputStream("D:\\Andriod\\day85\\java5\\src\\main\\java\\day15");

        byte[] buf = new byte[1024];
        int len;
        while ((len = is.read(buf)) != -1){
            fos.write(buf,0,len);
        }


    }

    //带参数的get请求
    public static void getParams() throws IOException{
        String path = "http://127.0.0.1/login.php?"+"user_name=jack&user_password=123";
        URL url = new URL(path);


        //获取连接的对象
        // URLconnection封装了Socket
        URLConnection connection = url.openConnection();

        //2、指明请求的方式，默认是get
        HttpURLConnection httpConnection =(HttpURLConnection)connection;
        httpConnection.setRequestMethod("get");

        //判断连接状态
        //接收服务器端的数据 BufferedReader 读取较快
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        System.out.println(br.readLine());
    }
}
