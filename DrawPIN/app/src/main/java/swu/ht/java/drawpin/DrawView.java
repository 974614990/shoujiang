package swu.ht.java.drawpin;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.provider.DocumentsContract;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.Iterator;

public class DrawView extends View {
    private ArrayList<ImageView> dotViews;
    private Point startPoint;
    private Point endPoint;
    private Paint mPaint;
    private ArrayList<Path> paths;

    public DrawView(Context context) {
        super(context);

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.WHITE);
        mPaint.setStrokeWidth(20);
        mPaint.setStyle(Paint.Style.STROKE);

        paths = new ArrayList<>();
    }


    public void setDotViews(ArrayList<ImageView> dotViews) {
        this.dotViews = dotViews;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        ImageView dot;
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                dot = viewContainedPoint(x,y);
                if(dot != null){
                    dot.setVisibility(VISIBLE);
                    //设置起始点
                    startPoint = new Point((int) (dot.getPivotX()+ dot.getX()),(int) (dot.getPivotY() +dot.getY()));
                }

                break;
            case MotionEvent.ACTION_MOVE:
                dot = viewContainedPoint(x,y);
                if (dot == null){
                    //画线
                    endPoint = new Point((int)x,(int)y);
                    //刷新
                    invalidate();
                }else {
                    //判断是否是第一个点还是其他
                    if(startPoint == null){
                        //第一个点
                        dot.setVisibility(VISIBLE);
                        //设置起始点
                        startPoint = new Point((int) (dot.getPivotX()+ dot.getX()),(int) (dot.getPivotY() +dot.getY()));
                    }else {
                        //点亮点
                        dot.setVisibility(VISIBLE);
                        //在之前和现在的点之间产生一个path
                        android.graphics.Path path = new android.graphics.Path();
                        path.moveTo(startPoint.x,startPoint.y);
                        path.lineTo(dot.getPivotX() + dot.getX(),
                                dot.getPivotY() + dot.getY());

//                        paths.add(path);

                        //当前这个这个点就是起始点
                        //设置起始点
                        startPoint = new Point((int)(dot.getPivotX() + dot.getX()), (int)(dot.getPivotY() + dot.getY()));

                        //刷新
                        invalidate();
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }

//    @Override
//    protected void onDraw(Canvas canvas) {
//        if (paths.size() > 0){
//            for (Path path: paths){
//                canvas.drawPath(path, mPaint);
//            }
//        }
//        if (startPoint != null && endPoint != null) {
//            canvas.drawLine(startPoint.x, startPoint.y,
//                    endPoint.x, endPoint.y, mPaint);
//        }
//    }

    //判断触摸点是否在某个dot里面
    private ImageView viewContainedPoint(float x, float y){
        for(ImageView dot : dotViews){
            int [] point = new int[2];
            dot.getLocationOnScreen(point);

            //获取dot的坐标
//            int px = point[0];
//            int py = point[1];
            int px = (int)dot.getX();
            int py = (int) dot.getY();

            if((x >= px && x <= px + dot.getWidth())
                    &&(y >= py && y <= py +dot.getHeight())){
                return dot;
            }
        }
        return null;
    }
}
