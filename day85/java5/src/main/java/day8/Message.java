package day8;

public class Message implements Setting.FontSettingInterface{
    private String color;
    private int size;
    private String test;

    //创建对象的方法
    public void Message(String test){
        this.test = test;
    }
    //通过一个方法进入到setting界面
    public void goToSetting(){
        //创建设置页面的对象
        Setting setting = new Setting(this);

        //进入设置
        setting.startSetting();
    }

    @Override
    public void change(String color, int size) {
        System.out.println("改变后的颜色："+color +" "+"改变后大小："+size);

    }
    //在message页面也需要提供一个方法接收外部的信息

}
