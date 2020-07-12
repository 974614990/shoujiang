package swu.ht.java.button;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/*
    View
    ImageView
    TextView
    EditView
    Button 接收用户的点按事件  按钮
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    boolean isnormal = true;
    Button btn;
    Button done;
    Button edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         btn = findViewById(R.id.bt_login);
         done = findViewById(R.id.bt_done);
         edit = findViewById(R.id.bt_edit);

         /*
        //给按钮添加点击事件
        btn.setOnClickListener(this);
        done.setOnClickListener(this);
        edit.setOnClickListener(this);
        */
         /*
         btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

             }
         });

         done.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

             }
         });

         edit.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

             }
         });
         */
         btn.setOnClickListener((view ->{
             //推荐使用
             if (btn.getTag().equals("1")) {
                 btn.setText("done");
                 btn.setTag("0");
             } else {
                 btn.setText("edit");
                 btn.setTag("1");
             }
         }));

         done.setOnClickListener((view ->{
             done.setEnabled(false);
             edit.setEnabled(true);
         }));
         edit.setOnClickListener((view -> {
             done.setEnabled(true);
             edit.setEnabled(false);
         }));
    }

    /*

        按钮的点击事件  通常接收一个参数：View
        当按钮被点击，系统接收这个事件
        并把这个事件回调给监听者
        把当前被点击的那个按钮作为参数传递过去
        1、android:onClick="login"
        注意：使用的时候必须转化为对应的类型
            不建议使用 很多情况下出错
        2、代码创建
     */
    public void login(View view) {
        System.out.println("点击了");
    }

    @Override
    public void onClick(View view) {
        //使用的时候转化为对应的子类类型
        Button btn = (Button) view;

        //更改按钮的标题  == 比较基本基本数据类型 对象的地址  equals 比内容
       // btn.setText("Edit");
        /*
       if(btn.getText().equals("Edit")){
           btn.setText("done");
        }else {
           btn.setText("Edit");
       }
       */

        //判断状态
        /*
        if(isnormal){
            btn.setText("Done");
        }else {
            btn.setText("Edit");
        }
        isnormal = !isnormal;
        */
        //通过空间的id来判断到底是哪个控件被点击
        if (btn.getId() == R.id.bt_login) {
            //推荐使用
            if (btn.getTag().equals("1")) {
                btn.setText("done");
                btn.setTag("0");
            } else {
                btn.setText("edit");
                btn.setTag("1");
            }
        }
        if(btn.getId() == R.id.bt_edit){
            done.setEnabled(true);
            edit.setEnabled(false);
        }
        if(btn.getId() == R.id.bt_done){
            done.setEnabled(false);
            edit.setEnabled(true);
        }
    }
}
