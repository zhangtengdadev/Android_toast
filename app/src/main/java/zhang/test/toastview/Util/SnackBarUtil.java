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
}
