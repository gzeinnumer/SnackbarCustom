# SnackbarCustom

- EasySnackbar.java
```java
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
```

- easy_snackbar.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_gravity="center"
    tools:ignore="HardcodedText">

    <androidx.cardview.widget.CardView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_margin="8dp"
        android:elevation="4dp"
        app:cardBackgroundColor="@color/purple_500"
        app:cardCornerRadius="4dp"
        app:cardPreventCornerOverlap="true"
        app:cardUseCompatPadding="true">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:padding="8dp">

            <TextView
                android:id="@+id/tv_content"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="Computer Science Portal"
                android:textColor="@android:color/white"
                android:textSize="14sp" />

        </LinearLayout>
    </androidx.cardview.widget.CardView>
</LinearLayout>
```

---

```
Copyright 2021 M. Fadli Zein
```