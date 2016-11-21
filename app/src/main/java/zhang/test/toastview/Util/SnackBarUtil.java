package zhang.test.toastview.Util;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import zhang.test.toastview.R;

/**
 * snackbar的工具类
 */

public class SnackBarUtil {
    public static final   int Info = 1;
    public static final  int Confirm = 2;
    public static final  int Warning = 3;
    public static final  int Alert = 4;


    public static  int red = 0xfff44336;
    public static  int green = 0xff4caf50;
    public static  int blue = 0xff2195f3;
    public static  int orange = 0xffffc107;

    /**
     * 普通的snackbar
     *
     * @param view 传过来的view
     */
    public static void CommonSnackBar(View view) {
        // Snackbar.LENGTH_INDEFINITE 一直显示
        final Snackbar snackbar = Snackbar.make(view, "普通的snackbar", Snackbar
                .LENGTH_INDEFINITE);
        snackbar.show();
        snackbar.setAction("关闭", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                snackbar.dismiss();
            }
        });
    }

    /**
     * snackbar样式
     *
     * @param view    传过来的view
     * @param context 引用
     */
    public static void StyleSnackBar(View view, Context context) {
        final Snackbar snackbar = Snackbar.make(view, "snackbar样式", Snackbar
                .LENGTH_LONG);
        //设置动作按钮颜色,就是关闭的颜色
        snackbar.setActionTextColor(context.getResources().getColor(R.color.add_bg_color));
        //获取 snackbar 视图
        View snackbarView = snackbar.getView();

        //设置修改snackbar文本颜色
        int snackbarTextId = android.support.design.R.id.snackbar_text;
        TextView tv = (TextView) snackbarView.findViewById(snackbarTextId);
        tv.setTextColor(context.getResources().getColor(R.color.add_bg_color));
        //设置snackbar背景色
        snackbarView.setBackgroundColor(Color.GRAY);
        snackbar.show();
        snackbar.setAction("关闭", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                snackbar.dismiss();
            }
        });
    }

    public static void setSnackBarLocation(View view, Context context) {
        final Snackbar snackbar = Snackbar.make(view, "snackbar位置", Snackbar
                .LENGTH_LONG);
        View snackbarView = snackbar.getView();
        ViewGroup.LayoutParams vl = snackbarView.getLayoutParams();
        //设置icon
        ImageView iconImage = new ImageView(context);
        iconImage.setImageResource(R.mipmap.ic_launcher);
        //icon插入布局
        Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackbarView;
        Snackbar.SnackbarLayout.LayoutParams sl = new
                Snackbar.SnackbarLayout.LayoutParams(vl.WRAP_CONTENT, vl.WRAP_CONTENT);
        //让icon的布局位于父布局垂直居中的位置
        sl.gravity = Gravity.CENTER_VERTICAL;
        iconImage.setLayoutParams(sl);
        snackbarLayout.addView(iconImage, 0);

        // 获取 snackbar 视图
        CoordinatorLayout.LayoutParams cl = new CoordinatorLayout.LayoutParams(vl.width, vl.height);
        cl.gravity = Gravity.CENTER_VERTICAL;
        snackbarView.setLayoutParams(cl);
        snackbar.show();
    }

    /**
     * 自定义时间snackBar
     */
    public static void setDurationSnackBar(View view, String message, int duration) {
        Snackbar snackbar = Snackbar.make(view,message, Snackbar.LENGTH_INDEFINITE).setDuration(duration);
        switchType(snackbar, Alert);
        snackbar.show();
    }

    //选择预设类型
    private static void switchType(Snackbar snackbar,int type){
        switch (type){
            case Info:
                setSnackbarColor(snackbar,blue);
                break;
            case Confirm:
                setSnackbarColor(snackbar,green);
                break;
            case Warning:
                setSnackbarColor(snackbar,orange);
                break;
            case Alert:
                setSnackbarColor(snackbar,Color.YELLOW,red);
                break;
        }
    }

    /**
     * 设置Snackbar背景颜色
     */
    public static void setSnackbarColor(Snackbar snackbar, int backgroundColor) {
        View view = snackbar.getView();
        if(view!=null){
            view.setBackgroundColor(backgroundColor);
        }
    }

    /**
     * 设置Snackbar文字和背景颜色
     */
    public static void setSnackbarColor(Snackbar snackbar, int messageColor, int backgroundColor) {
        View view = snackbar.getView();
        if(view!=null){
            view.setBackgroundColor(backgroundColor);
            ((TextView) view.findViewById(R.id.snackbar_text)).setTextColor(messageColor);
        }
    }
}
