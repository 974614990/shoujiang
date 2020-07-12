package swu.ht.java.pin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  implements TextView.OnEditorActionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //通过id获取xml里面对应的控件
        EditText et = findViewById(R.id.et_password);


        //监听键盘的key按下的事件
        //1、创建匿名类对象

        /* 1.1创建一个类管理事件
        PXDListener pl = new PXDListener();
        et.setOnEditorActionListener(pl);
        */

        //或者
        //et.setOnEditorActionListener(new PXDListener());

        //1.2匿名类对象
        /*
        et.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return false;
            }
        });
        */
        //1.3Lambda表达式
            /*
        et.setOnEditorActionListener((textView,action,event) -> {
            System.out.println("点击了");
            return ture;

                });
            */

                //2、当前这个Activity来监听事件
                //et.setOnEditorActionListener(this);

        //监听EditText文本内容改变事件
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
               // System.out.println("改变前：" + et.getText().toString());
            }

            /*
                   CharSequence charSequence :显示的文本内容
                   int i(start) ： 0
                   int （i1）before: 改变之前最后一个字符的位置
                   int (i2)count; 添加字符的个数

                   before < count : 添加
                   before > count : 删除字符
                    限制输入的个数是3个
             */
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //System.out.println("正在改变：" + et.getText().toString());
                //获取目前输入的个数
                int len = charSequence.toString().length();

                if(len > 6){
                    //将最后一个删除掉 只要前面6个   subSequence 字符序列
                    et.setText(charSequence.subSequence(0,6));

                    //让光标定位在最后
                    et.setSelection(6);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {
               // System.out.println("改变后：" + et.getText().toString());

            }
        });
    }

    //监听键盘被按下的回调事件
    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        System.out.println("点击了");
        return false;
    }
}

//创建一个类 管理事件的回调
class PXDListener implements TextView.OnEditorActionListener{

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {

        System.out.println("点击了");
        return false;
    }
}
/*

    创建控件方式：
            1、xml配置文件
            2、使用代码创建
    EditText:

 */
