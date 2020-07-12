package swu.ht.java.waveloading;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.ViewGroup;

public class WaveLoadingView extends ViewGroup {
    private float Progress;
   private CircleView cv;//进度圈
    private WaveView wv;//贝塞尔曲线
    public WaveLoadingView(Context context) {
        super(context);

    }

    public WaveLoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

  /*
             ViewGroup中 通过测量左右子视图来确定当前容器的宽高
   */

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /*
         对子视图进行布局
         changed 是否改变过
         l  = left
         t  =top
         r  =right
         b  =bottom
    */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //创建CircleView
         cv = new CircleView(getContext());
        cv.setLineColor(Color.RED);
        cv.setLineSize(50);
        cv.setTextColor(Color.RED);
        cv.setCenterYSpace(-90);
        //对子视图进行布局
        cv.layout(0,0,getWidth(),getHeight());
        //将子视图添加到容器中
        addView(cv);

        //创建WaveView
        wv = new WaveView(getContext());
        wv.setLineSize(5);
        wv.setWaveCrest(30);
        wv.setWaveLenth(100);
        wv.setLineColor(Color.BLACK);

        //布局
        wv.layout(getWidth()/4,getHeight()/2-30,getWidth()*3/4,getHeight()/2+30);
        //添加
        addView(wv);


    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    public void setProgress(float progress) {
        Progress = progress;
        //改变CircleView的进度值
        cv.setProgress(progress);
        if(progress <=1 ){
            cv.setProgress(progress);
        }
        if((int)progress == 1.01){
            wv.stopWave();
        }
    }

    public float getProgress() {
        return Progress;
    }
}
