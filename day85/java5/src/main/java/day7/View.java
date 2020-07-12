package day7;

/**
 * 管理一个视图显示和事件监听
 * 什么情况下需要将一个父类做成抽象类（模板）
 * 1、不能直接创建这个类的对象
 * 2、这个类里面的某些方法还不确定如何实现
 */
public class View {
    //所有试图都共有的属性
        String backgroundColor;
        String borderColor;

        //记录谁像监听我这个事件
    //暂时我不确定是谁要来监听 但是要监听事件的人肯定要实现这个接口
    OnClickListener listener;

    //所有的视图都要监听事件
    //定义内部接口 封装
    public interface OnClickListener{
    //定义一套方法 约束外部使用这些方法来监听事件
        void onClick(View v);

    }
}
