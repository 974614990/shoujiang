package swu.ht.java.drawpin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ImageView> dotViews;
    RelativeLayout rl;
    DrawView drawView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rl = findViewById(R.id.rl_root);
        dotViews = new ArrayList<>();

        //显示正常点
        initNineDot(R.drawable.a, View.VISIBLE);
        //绘制的视图
        initDrawView();
        //点亮的点
        initNineDot(R.drawable.b, View.VISIBLE);

        //将所有点的数组传递给DrawView
        drawView.setDotViews(dotViews);

    }
    private void initDrawView(){
        drawView = new DrawView(this);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        rl.addView(drawView, params);
    }

    //图片 隐藏 tag  初始化9个点
    private void initNineDot(int res,int visible){
        float padding = pixelFromDp(40);

        //计算两个点中心点之间的间距
        Point p = new Point();
        getWindowManager()
                .getDefaultDisplay()
                .getSize(p);

        //获取图片
        Bitmap bitmap = BitmapFactory
                .decodeResource(getResources()
                        ,res);
        float space = (p.x - 2 * padding - bitmap.getWidth())/2;

        //确定第一个点的x和y
        float x = padding;
        float y = p.y/2 - space - bitmap.getHeight();

        int index = 1;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                createDot(res,(int) (x + space*j), (int) (y + space*i),visible);
            }
        }
    }

    //创建图片视图
    private void createDot(int res,int left,int top,int visible){

        ImageView iv = new ImageView(this);
        iv.setBackgroundResource(res);
        iv.setVisibility(visible);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.leftMargin = left;
        params.topMargin = top;

        //添加视图
        rl.addView(iv,params);

        //判断res对应是选择的还是正常的
        if(res == R.drawable.b){
            dotViews.add(iv);
        }
    }
    //计算dp对应的像素值
    private float pixelFromDp(int size){
        //获取屏幕的密度
        return size * getResources()
                .getDisplayMetrics()
                .density;
    }

}
