package day8;

/**
 * 阅读界面 显示文本
 */
public class Read implements Setting.FontSettingInterface{
    /**
    private String text;
    private String color;//默认的颜色
    private int size;//默认的字体大小

    public Read(String text){
        this.text = text;
    }
    //模拟进入设置页面
    public void goToSetting(){
        //1、创建设置页面的对象
        Setting setting = new Setting(this);

        //2、进入设置页面
        setting.startSetting();
    }
    //提供给外部一个方法可以通过这个 方法给我传值
    public void change(String color,int size){
        System.out.println("改变前的颜色："+this.color+"改变前的大小："+this.size);
        this.color = color;
        this.size = size ;
        System.out.println("改变后的颜色："+this.color+" "+"改变后的大小："+this.size);
    }
     */
    //通过阅读界面去进入设置里面去更改字体的大小和颜色
    private String text;
    private String color;
    private int size;

    //创建一个操作对象的方法
    public void Read(String text){
        this.text = text;
    }
    //通过一个入口进入设置界面
    public void goToSetting(){
        //创建设置页面的对象
        Setting setting = new Setting(this);

        //进入设置
        setting.startSetting();
    }

    public void change(String color,int size){
        this.size = size ;
        this .color = color;
        System.out.println("改变后的颜色："+color +" "+"改变后大小："+size);
    }
}
