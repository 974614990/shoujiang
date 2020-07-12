package day9.demo;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOperation {
    public static final String PATH = "/Users/pengxiaodong/Desktop/day1/java/src/main/java/day8/Demo/pwd.txt";
    String password;

    public static final FileOperation instance = new FileOperation();

    private FileOperation(){
        try {
            load();
        }catch (IOException e){
            System.out.println("io 异常");
        }
    }

    public void load() throws IOException {
        FileInputStream fis = new FileInputStream(PATH);

        byte[] pwd = new byte[4];

        int count = fis.read(pwd);

        if (count == -1){
            password = null;
        }else{
            password = new String(pwd);
        }
        fis.close();
    }

    public void save(String password){
        try {
            FileOutputStream fos = new FileOutputStream(PATH);
            fos.write(password.getBytes());
            fos.close();
        } catch (IOException e){
            System.out.println("io异常");
        }
    }
}
