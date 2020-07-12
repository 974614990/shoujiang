package day7;

/**
 * 创建按钮类
 */
public class Button extends View {
    String title;
    String titleColor;

    public Button(String title,String titleColor){
        this.title = title;
        this .titleColor = titleColor;
    }
    //用于获取接受触摸事件
    public void getTouchEvent(){
        //调用监听者里面的onClick方法
        listener.onClick(this);
    }

}
