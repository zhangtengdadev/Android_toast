package zhang.test.toastview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
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

    @OnClick({R.id.bt_toast})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_toast: // 吐司
                openToast();
                break;
        }
    }

    private void openToast() {
        ToastUtils.showToast(this, 0, "吐司产生了，我们要开始出发");
    }
}
