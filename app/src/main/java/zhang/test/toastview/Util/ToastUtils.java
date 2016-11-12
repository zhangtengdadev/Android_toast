package zhang.test.toastview.Util;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import zhang.test.toastview.R;

/**
 * Created by Administrator on 2016/11/11.
 */

public class ToastUtils extends Toast {
    private static Toast mToast;

    public ToastUtils(Context context) {
        super(context);
    }

    /**
     * 自定义Toast样式
     *
     * @param context
     * @param resId
     * @param text
     * @param duration hrq 2014-7-10下午2:15:36
     * @description
     */
    public static Toast makeText(Context context, int resId, CharSequence text,
                                 int duration) {
        Toast result = new Toast(context);

        // 获取LayoutInflater对象
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // 由layout文件创建一个View对象
        View layout = inflater.inflate(R.layout.toast_ui, null);

        // 实例化ImageView和TextView对象
        ImageView imageView = (ImageView) layout.findViewById(R.id.toast_iv);
        TextView textView = (TextView) layout.findViewById(R.id.toast_tv);

        //这里我为了给大家展示就使用这个方面既能显示无图也能显示带图的toast
        if (resId == 0) {
            imageView.setVisibility(View.GONE);
        } else {
            imageView.setImageResource(resId);
        }

        textView.setText(text);

        result.setView(layout);
        result.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        result.setDuration(duration);

        return result;
    }

    /**
     * 产生一个toast，直接从内部调用
     *
     * @param context 引用
     * @param resId   是否显示图像，0不显示，显示的话直接传入
     * @param content 要显示的内容
     */
    public static void showToast(Context context, int resId, String content) {

        if(mToast == null){
            mToast = ToastUtils.makeText(context, resId, content, 100);
        }
        mToast.show();
    }
}
