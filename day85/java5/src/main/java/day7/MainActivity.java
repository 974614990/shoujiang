package day7;

/**
 * 主界面 （程序运行起来的第一个界面）
 */
public class MainActivity extends Activity implements View.OnClickListener {
    Button btn;
    ImageView img;
    //构造方法
    public MainActivity(){
        //当界面被创建就自动调用onCreate方法
        onCreate();
    }
   @Override
    public void onCreate(){
       //主界面如何布局
       //添加一个按钮
        btn = new Button("分享","红色");

       //添加一张图片
        img = new ImageView("周杰伦");

       //将创建的控件添加到当前界面
       addChild(btn);
       addChild(img);
        //1.
       //如果一个控件需要监听事件 那么就必须实现监听事件的接口
       //告诉按钮是谁要监听这个事件
       btn.listener = this;

       //2.使用匿名类给图片添加事件监听器
       img.listener = new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               System.out.println("图片被点击了");
           }
       };
    }

    //模拟触摸
    public void touch(){
       //将屏幕触摸的事件传递给按钮
        btn.getTouchEvent();
        //img.getTouchEvent();
    }
    @Override
    public void onDestory(){
       //销毁之前需要做点什么事情
    }

    //当事件触发 就回来调用这个onClick方法
    @Override
    public  void onClick(View view){
       System.out.println("按钮被点击了");
    }

}
