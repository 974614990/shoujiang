package swu.ht.java.waveloading;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class CircleView extends View {
    Paint cirlePaint;
    Paint textPaint;
    private int lineSize= 20;//线条粗细
    private int lineColor= Color.BLACK;//线条颜色
    private int textColor= Color.BLACK;//文本颜色
    private int textSize = 50;//文本大小
    private float progress;  //进度
    private int centerYSpace= 0;   //和中心线y的距离

    public CircleView(Context context) {
        super(context);
        inti();
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        inti();
    }
    public void inti(){
        cirlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        cirlePaint.setColor(lineColor);
        cirlePaint.setStyle(Paint.Style.STROKE);
        cirlePaint.setStrokeWidth(lineSize);

        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(textColor);
        textPaint.setTextSize(textSize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //确定半径
        int radius = Math.min(getWidth(),getHeight())/2-lineSize;
        //画圆
        canvas.drawCircle(getPivotX(),getPivotY(),radius,cirlePaint);

        //画文本
        String text = (int)(progress*100)+"%";
        //计算文本宽度
        int width = (int)textPaint.measureText(text);
        //获取文字矩阵
        Paint.FontMetricsInt fm =textPaint.getFontMetricsInt();

        canvas.drawText(text,getPivotX()-width/2,getPivotY()+(-fm.ascent)/2,textPaint);
    }

    public void setLineSize(int lineSize) {
        this.lineSize = lineSize;
        cirlePaint.setStrokeWidth(lineSize);
    }

    public void setLineColor(int lineColor) {
        this.lineColor = lineColor;
        cirlePaint.setColor(lineColor);
    }

    public void setTextSize(Paint cirlePaint) {
        this.cirlePaint = cirlePaint;
        textPaint.setStrokeWidth(textSize);
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
        textPaint.setColor(textColor);
    }

    public void setProgress(float progress) {
        this.progress = progress;
        //刷新
        invalidate();
    }

    public float getProgress() {
        return progress;
    }

    public void setCenterYSpace(int centerYSpace) {
        this.centerYSpace = centerYSpace;
    }
}
