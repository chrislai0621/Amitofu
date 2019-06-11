package com.chrislai.chris.amitofu2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Context extends AppCompatActivity {
    private String[] mArrayTitle;
    private TextView tvName, tvContext;
    private CharSequence[] mContext;
    private LinearLayout mTextViewPort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context);
        init();
        setView();
    }

    private void init() {
        tvContext = (TextView) findViewById(R.id.express_content);
        tvContext.setMovementMethod(new ScrollingMovementMethod());


    }

    private void setView() {

        switch (Setting.Language) {
            case "TC":
                mArrayTitle = getResources().getStringArray(R.array.tc_title);
                mContext =getResources().getStringArray(R.array.tc_context);
                //setTcContext();
                break;
            case "SC":
                mArrayTitle = getResources().getStringArray(R.array.sc_title);
                mContext =getResources().getStringArray(R.array.sc_context);
                //setScContext();
                break;
        }


        tvContext.setTextSize(Setting.fontSize);
        tvContext.setText(Html.fromHtml("<b>"+ mArrayTitle[MainActivity.contextIndex]+"</b><br>"+
                mContext[MainActivity.contextIndex].toString()));
    }
}
