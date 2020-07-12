package day9;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import javax.print.attribute.standard.OutputDeviceAssigned;

/**
 * 文件的相关操作
 *
 * 是否存在  创建文件 写入数据 读取内容
 * File
 */
public class MyClass {
    public static void main(String [] args) throws IOException, ClassNotFoundException {//throws IOException  提示错误如何处理  file.createNewFile();
        //创建文件 具体的完整路径
        /**
        String path = "/Andriod/day85/java5/src/main/java/day9";
        //path/1.txt
        File file = new File(path.concat("/1.txt"));

        //判断是否存在
        if(file.exists() == false) {
            //不存在就去创建
           file.createNewFile();
           /** try { 抛出异常 如何处理
                file.createNewFile();
            }catch (IOException e){
                System.out.println("IO异常了");
            }*/


        //读取文件相应的内容
        //I  O 流  流的方向 ：参考的是自己的内存空间
        //输出流：从内存空间将数据写到外部设备（磁盘、硬盘、光盘）
        //输入流：将外部数据写到内存中
        //流 stream  统一管理数据的写入和读取 开发者将内存里面的数据写到stream流里面 或者从流里面读取数据 输入输出流

        //输出流OutputStream 字节流 Writer字符流默认文件指针只向开头从文件开头写 write是接着文件里面的内容后免写

        //RandomAccessFile 随机访问文件 seek\从某个地方写
        // 输入流 InputStream 字节流  Reader 字符流
        //I/O 流对象不属于内存对象 需要自己关闭
        //OutputStream 和 InputStream都是抽象类 不能直接使用
        //FileOutputStream /FileInputStream 文件
        //ObjectOutputStream/ObjectInputStream  对象

        /**
        //向文件写入数据 字节流
        //1、创建文件输出流对象
        FileOutputStream fos = new FileOutputStream(file);

        //调用write方法写入
        byte[] text = {'1','2','3','4'};
        fos.write(text);

        ///3、操作完毕需要关闭stream对象
        fos.close();

        //写入数据字符流
        FileWriter fw = new FileWriter(file);

        char [] name = {'安','卓','开','发'};
        fw.write(name);
        fw.close();

         */

        /**
        //读取内容 read
        FileInputStream fis = new FileInputStream(file);
        byte [] name1 = new byte[12];
        fis.read(name1);
        fis.close();

        System.out.println(new String(name1));

        FileReader fr = new FileReader(file);

        char [] book = new char[4];
        int count = fr.read(book);

        fr.close();
        System.out.println(new String(book));

         */
        //向文件里面存一个对象

        //序列化 serializable
        //保存的对象必须实现 serializable接口
        //如果对象内部还有属性变量是其他类的对象 那么这个类也必须实现serializable接口
        /**
        Person xw = new Person();
        xw.age = 20;
        xw.name = "小王";

        OutputStream os = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(xw);
        oos.close();
         */
        //从文件里面读取一个对象
        /*
        InputStream is = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(is);
        Person xw = (Person) ois.readObject();

        System.out.println(xw.name +" "+xw.age);

        ois.close();
        */

        long start = System.currentTimeMillis();
        //将一个文件copy到另外一个位置
        //1、源文件的路径
        String sourcePath = "C:/Users/asus/Desktop/1.jpg";

        //2、目标文件的路径
        String desPath = "/Andriod/day85/java5/src/main/java/day9/1.jpg";

        //3、图片 视频 音频 字节
        FileInputStream fis = new FileInputStream(sourcePath);//读出
        FileOutputStream fos = new FileOutputStream(desPath);//写入

        byte[] in = new byte[1024];
       /*
        while (true){
            int count = fis.read(in);  //count = -1则取完了
            if (count != -1){
                //读取到内容了
                //将这一次读取的内容写入到目标文件
                fos.write(in,0,count);
            }else{
                //写完了
                break;
            }
        }
        */
       int count = 0;
       while ((count = fis.read(in)) !=-1){
           fos.write(in,0,count);
        }
        fis.close();
        fos.close();

        long end = System.currentTimeMillis();

        System.out.println(end - start);

    }
}
