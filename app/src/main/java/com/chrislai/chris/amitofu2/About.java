    package com.chrislai.chris.amitofu2;

    import android.os.Bundle;
    import android.support.v7.app.AppCompatActivity;
    import android.text.method.ScrollingMovementMethod;
    import android.widget.TextView;

    public class About extends AppCompatActivity {

    private TextView tvAbout;
    private CharSequence mAbout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        init();
        setView();

    }
    private void init() {
        tvAbout = (TextView) findViewById(R.id.tvAbout);
        tvAbout.setMovementMethod(new ScrollingMovementMethod());


    }
    private void setView() {

        switch (Setting.Language) {
            case "TC":

                mAbout =getResources().getString(R.string.tc_about);

                break;
            case "SC":
                mAbout =getResources().getString(R.string.sc_about);
                break;
        }


        tvAbout.setTextSize(Setting.fontSize);
        tvAbout.setText(mAbout);
    }
}
