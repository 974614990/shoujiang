package swu.ht.java.drawboard;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

/*
    画板demo：
        1、横竖屏切换 配置文件manifest  screenOrientation="sensor"
                sensor 传感器（感应屏幕的方向，随着屏幕的方向变化而变化）
                portrait 屏幕不会旋转 固定竖屏
                sensorPortrait 倒着旋转
                Landscape 横屏固定
                SensorLandscape 感应的横向切换

         2、代码创建 onResume 里面调用setRequestedOrientation方法

    相对关系： ConstraintLayout

    滑动条SeekBar


    自定义滑动条Slider
      1、进度条：没有thumb小圆点 不接受触摸事件
      2、滑动条：有thumb小圆点 接受触摸事件
                                （1）当触摸的时候小圆点放大
                                （2）监听滑动事件
      3、横竖切换：width> height 横着  width < height 竖着

      创建slider extends View
 */
public class MainActivity extends AppCompatActivity {
    private DrawBoardView boardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取画板视图对象
        boardView = findViewById(R.id.board);
        //获取滑动条视图对象
        final Slider slider =findViewById(R.id.slider);
        slider.setMax(30);
        slider.setStyle(Slider.SLIDER);
        slider.setOnSliderChangeListener(new Slider.OnSliderChangeListener() {
          @Override
          public void progressChanged(float progress) {
              //滑动条的进度值 设置为线条的宽度
              boardView.setLineSize((int)progress);
          }
           });

        slider.setProgress(boardView.getLineSize());


        /*
            绘制过程：
              测量onMeasure
              绘制onDraw
         */
        /*
        new Timer().schedule(new TimerTask() {
         @Override
        public void run() {
         slider.setProgress((float)(slider.getProgress() + 0.01));
         }

          },0,100);
          */

        /*

        SeekBar slider = findViewById(R.id.slider);
        //监听滑动条滑动事件
        slider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //进度值改变了
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //即将开始拖拽
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            //拖拽完成
            }
        });
        关键帧动画
          补间动画：旋转 移动 缩放 渐变
          属性动画： ObjectAnimator
          ValueAnimator 0-20
         ViewPropertyAnimator animate().动画    slider.animate().rotation(90)
        slider.animate().rotation(90);
         */
    }
    public void choiceColor(View view){
        //获取按钮上背景图片的颜色
        ColorDrawable drawable = (ColorDrawable)view.getBackground();

        //获取颜色
        boardView.setLineColor(drawable.getColor());

    }


    @Override
    protected void onResume() {
        super.onResume();
        //设置横竖屏切换
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR);
    }

    //撤销
    public void goBack(View view) {
        boardView.removeLast();
    }

    //清空
    public void Clear(View view) {
        boardView.removeAll();
    }

    //橡皮擦
    public void eraser(View view) {
        //获取画板的drawable
        ColorDrawable drawable = (ColorDrawable)boardView.getBackground();
        //设置线条的颜色和背景色相同
        if(drawable != null){
            boardView.setLineColor(drawable.getColor());
        }else {
            boardView.setLineColor(Color.TRANSPARENT);
        }
    }

    //保存
    public void save(View view) {
    }

    //还原  上一步  Ctrl+Z
    public void lastStep(View view) {
        boardView.goTolastStep();
    }
}
