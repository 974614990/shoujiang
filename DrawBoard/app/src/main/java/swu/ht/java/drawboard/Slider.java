package swu.ht.java.drawboard;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class Slider extends View {
    private int lineSize = 5; //线条粗细
    private int lineColor = Color.BLACK; //默认线条黑色
    private Paint linePaint;  //线的画笔

    private Paint circlePaint; //圆的画笔
    private int thumbColor = Color.MAGENTA;   //小圆点的颜色
    private int cx;  //中心点x
    private int cy;  //中心点y
    private int radius;  //小圆点的半径

    private int thumbScale = 4;//小圆点的尺寸缩放比例
    private float position ;  //记录触摸点的坐标

    private Paint progressPaint; //进度条画笔
    private int progressColor = Color.MAGENTA; //进度条默认颜色

    public static int PROGRESS = 0; //进度条
    public static int SLIDER = 1; // 滑动条
    private int style = PROGRESS; //默认样式

    public int max = 100;  //设置最大值
    public float progress ; //进度值
    //滑动改变的监听者
    private OnSliderChangeListener onSliderChangeListener ;
    //代码
    public Slider(Context context) {
        super(context);
    }
    //xml配制
    public Slider(Context context,  AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        // 线条
        linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setColor(lineColor);
        linePaint.setStrokeWidth(lineSize);

        //小圆点
        circlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        circlePaint.setColor(thumbColor);
        circlePaint.setStyle(Paint.Style.FILL);

        // 进度条
        progressPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        progressPaint.setColor(progressColor);
        progressPaint.setStrokeWidth(lineSize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //canvas 画布
        if(getWidth() > getHeight()){
            //横着
            canvas.drawLine(0,getHeight()/2,getWidth(),getHeight()/2,linePaint);
            if(position > 0){
                //画进度条背景
                canvas.drawLine(0,getHeight()/2,getWidth(),getHeight()/2,progressPaint);
            }
            cy = getHeight()/2 ;
            radius = getHeight()/thumbScale;
            //确定cx的值
            if(position < radius){
                cx = radius;
            }else if(position > getWidth()- radius){
                cx = getWidth() - radius;
            }else {
                cx = (int)position;
            }
        }else {
            //竖着
            canvas.drawLine(getWidth()/2,0,getWidth()/2,getHeight(),linePaint);
            if(position>0){
                canvas.drawLine(getWidth()/2,0,getWidth()/2,position,progressPaint);
            }
            cx = getWidth()/2;
            radius = getWidth()/thumbScale;
            //确定中点cy的值
            if(position < radius){
                cy = radius;
            }else if(position > getHeight() - radius){
                cy = getHeight() - radius;
            }else {
                cy = (int)position;
            }
        }
        //画小圆点
        if(style == SLIDER){
            canvas.drawCircle(cx,cy,radius,circlePaint);
        }
    }

    //内部交互
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                //小圆点放大
                thumbScale = 2;
                if(getWidth() > getHeight()){
                    //横着 getWidth 表示得到LinearLayout的大小   y不变 x 改变
                    position = event.getX();
                }else {
                    //竖着  x 不变 y 改变
                    position = event.getY();
                    if(position < 0){
                        position=0;
                    }else if(position > getHeight()){
                        position = getHeight();
                    }
                }
                callBake();
                 break;
            case MotionEvent.ACTION_MOVE:
                //横竖两种情况
                //获取当前触摸点的值 x y
                if(getWidth() > getHeight()){
                    //横着 getWidth 表示得到LinearLayout的大小   y不变 x 改变
                    position = event.getX();
                }else {
                    //竖着  x 不变 y 改变
                    position = event.getY();
                    if(position < 0){
                        position=0;
                    }else if(position > getHeight()){
                        position = getHeight();
                    }
                }
                callBake();
                 break;
            case MotionEvent.ACTION_UP:
                thumbScale = 4;
                 break;
        }
        if(style == SLIDER){
            //重新绘制
            invalidate();
        }
        return true;
    }

    //得到进度值
    private void callBake(){
        if(onSliderChangeListener != null){
            if(getWidth() > getHeight()){
                progress = position / getWidth();
            }else {
                progress = position / getHeight();
            }
            onSliderChangeListener.progressChanged(progress*max);
        }
    }
    public int getStyle() {
        return style;
    }

    public void setStyle(int style) {
        this.style = style;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (getWidth() > getHeight()) {
            position = progress * getWidth();
        } else {
            position = progress * getHeight();
        }
    }
    //方法的重载
    public void setProgress(int progress){
        //计算比例
        float rate = (float)(progress*1.0 / max);
        setProgress(rate);
    }
    public void setProgress(float progress) {
        this.progress = progress;
        if(progress < 1.001){
            if(getWidth() > getHeight()){
                position = progress *getWidth();
            }else {
                position = progress * getHeight();
            }
        }
        //将进度值转化为屏幕的尺寸位置
        invalidate();
    }

    public float getProgress() {
        return progress;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
    public interface OnSliderChangeListener{
        void progressChanged(float progress);
    }

    public void setOnSliderChangeListener(OnSliderChangeListener onSliderChangeListener) {
        this.onSliderChangeListener = onSliderChangeListener;
    }
}
