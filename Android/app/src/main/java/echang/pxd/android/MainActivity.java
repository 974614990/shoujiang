package echang.pxd.android;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    /*
    获取xml里面的的所有图片试图
    先用一个数组保存所有试图的id号
    用一个数组保存所有的id号对应的试图
*/
       private int[] resID={R.id.iv_b,R.id.iv_c,R.id.iv_d,R.id.iv_e,R.id.iv_f,R.id.iv_g,R.id.iv_h};
        private List<ImageView> imageViews = new ArrayList<>();
    private boolean isOpen = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
           /**将id号对应的图片试图读取出来 放到ImageViews里面
            *
            */
           for(int i =0;i< resID.length;i++ )
           {
               int id =resID[i];
               ImageView img = findViewById(id);
               imageViews.add(img);

           }
    }

    public void imgClicked(View view) {
        if(isOpen == true){
            close();
        }else{
            open();
        }
        isOpen = !isOpen;
    }
    private  void close(){
        for(int i =0; i< imageViews.size(); i++ ){
            ImageView iv= imageViews.get(i);
            ObjectAnimator oa = ObjectAnimator.ofFloat(iv,"translationY",(i+1)*200f,0f);
            oa.setDuration(1000);
            oa.start();

        }
    }
    private void open(){
        for(int i =0; i< imageViews.size(); i++ ){
            ImageView iv= imageViews.get(i);
           ObjectAnimator oa = ObjectAnimator.ofFloat(iv,"translationY",0f,(i+1)*200f);
           oa.setDuration(1000);
           oa.setInterpolator(new BounceInterpolator());
           oa.start();
        }
    }

}
