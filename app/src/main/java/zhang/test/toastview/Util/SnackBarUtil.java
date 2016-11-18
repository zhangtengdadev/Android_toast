package zhang.test.toastview.Util;

import android.support.design.widget.Snackbar;
import android.view.View;

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
        final Snackbar snackbar = Snackbar.make(view, "普通的snackbar", Snackbar
                .LENGTH_LONG);
        snackbar.show();
        snackbar.setAction("关闭", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                snackbar.dismiss();
            }
        });
    }
}
