package day8;

/**
 * 设置界面 设置字体大小和颜色
 */
public class Setting {
    /**
    Read r1;//记录为谁设置颜色和大小，记录下我做完事情过后将数据返回给谁
    //开始设置
    //创建对象的时候 就需要告诉你是谁

    public Setting (Read r1){
        this.r1 = r1;
    }
    public void startSetting(){
        System.out.println("开始设置");
        System.out.println("。。。。");
        System.out.println("设置成功");

        //1.如果又可以访问的属性 直接通过属性给值  比较少用对方没办法第一时间知道自己需要的值有了 例如：r1.color
        //2.通过方法回调
        r1.change("红色",20);
    }
     */
    /**
    Read r1; //告诉谁来设置
    Message c1;
    public Setting (Read r1){
        this.r1 = r1;
    }
    public Setting (Message c1){
        this.c1 = c1;
    }
    public void startSetting(){
        System.out.println("开始设置");
        System.out.println("设置成功");
        if(r1 != null) {
            r1.change("黑色", 20);
        }
        if(c1 != null){
        c1.doChange("红色",20);
        }
    }

    */
    FontSettingInterface obj;

    public Setting (FontSettingInterface obj){
        this.obj = obj;
    }

    //使用接口定义一套方法 强制使用者来实现这个方法
    public interface FontSettingInterface{
        //自己规定的方法
        void change(String color,int size);
    }
    public void startSetting() {
        System.out.println("开始设置");
        System.out.println("设置成功");
        obj.change("黑色",20);
    }

}
/**
 * 抽象类 普通类 接口
 * 1、是否需要添加成员变量  需要：抽象类 普通类   不需要： 接口
 * 2、添加的方法是不是必须要实现 必须 ：抽象类 接口  不需要 ；普通类 抽象类里面的普通方法
 * 3、是需要提供模板还是提供通讯方式  模板 ：抽象类  通讯 （通讯传递）：接口
 */