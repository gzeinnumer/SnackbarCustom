package com.gzeinnumer.snackbarcustom;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class EasySnackbar {
    private final Snackbar snackbar;
    private final View customSnackView;

    public EasySnackbar(Activity activity, View v) {
        snackbar = Snackbar.make(v, "", 10000);
        customSnackView = activity.getLayoutInflater().inflate(R.layout.easy_snackbar, null);
        snackbar.getView().setBackgroundColor(Color.TRANSPARENT);
        Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackbar.getView();
        snackbarLayout.setPadding(0, 0, 0, 0);
        customSnackView.getRootView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar.dismiss();
            }
        });

        snackbarLayout.addView(customSnackView, 0);
    }

    public EasySnackbar setContent(String msg) {
        ((TextView) customSnackView.findViewById(R.id.tv_content)).setText(msg);
        return this;
    }

    public EasySnackbar show() {
        snackbar.show();
        return this;
    }
}
