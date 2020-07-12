package swu.ht.java.animation;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;

/*
    动画（animation）
    关键帧动画 FrameAnimation
    使用多张图片快速切换  形成一种动画
        1、使用xml配制动画 -> 动画是固定的
            res->drawable里面创建动画的xml文件
        2、使用代码创建 -> 在运行过程中有变化
 */
public class MainActivity extends AppCompatActivity {
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1、创建一个动画资源
        AnimationDrawable anim = new AnimationDrawable();

        //2、添加每一帧的动画
        int[] resID = {R.drawable.campfire01,R.drawable.campfire02,R.drawable.campfire03,R.drawable.campfire04,R.drawable.campfire05,R.drawable.campfire06,R.drawable.campfire07,R.drawable.campfire08,R.drawable.campfire09,R.drawable.campfire10,R.drawable.campfire11,R.drawable.campfire12,R.drawable.campfire13,R.drawable.campfire14,R.drawable.campfire15,R.drawable.campfire16,R.drawable.campfire17};
        for(int id:resID){
            anim.addFrame(getResources().getDrawable(id,null),100);
        }
        //3、使用这个动画资源
        ImageView iv = findViewById(R.id.iv_animation);
        iv.setImageDrawable(anim);

        //4、启动动画
        anim.start();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            /*
            //1、获取动画的控件
            ImageView iv = findViewById(R.id.iv_animation);

            //2、通过控件获取动画
            AnimationDrawable anim = (AnimationDrawable) iv.getDrawable();

            //3、启动动画
            anim.start();
            */



        }
        return true;
    }
}
