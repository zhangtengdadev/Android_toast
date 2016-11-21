package zhang.test.toastview;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import zhang.test.toastview.Util.SnackBarUtil;
import zhang.test.toastview.Util.ToastUtils;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.bt_toast)
    Button btToast;
    @Bind(R.id.activity_main)
    LinearLayout activityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_toast, R.id.bt_common_snackbar, R.id.bt_style_snackbar,
            R.id.bt_state_snackbar, R.id.bt_set_duration_snackbar})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_toast: // 吐司
                openToast();
                break;

            case R.id.bt_common_snackbar:// 普通的snackbar
                openCommonSnackBar(view);
                break;

            case R.id.bt_style_snackbar:// snackbar的样式
                openStyleSnackBar(view, this);
                break;

            case R.id.bt_state_snackbar: // snackBar的位置
                openSateSnackBar(view);
                break;

            case R.id.bt_set_duration_snackbar: // 自定义时间和预选类型的设置
                openSetDurationSnackBar(view);
                break;
        }
    }

    private void openSetDurationSnackBar(View view) {
        SnackBarUtil.setDurationSnackBar(view, "自定义时间snackbar", 5000);
    }

    private void openSateSnackBar(View view) {
        SnackBarUtil.setSnackBarLocation(view, getApplicationContext());
    }

    private void openStyleSnackBar(View view, Context context) {
        SnackBarUtil.StyleSnackBar(view, context);
    }

    private void openCommonSnackBar(View view) {
        SnackBarUtil.CommonSnackBar(view);
    }

    private void openToast() {
        ToastUtils.showToast(this, 0, "吐司产生了，我们要开始出发");
    }
}
