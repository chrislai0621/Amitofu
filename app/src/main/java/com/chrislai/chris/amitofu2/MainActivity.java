package com.chrislai.chris.amitofu2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout LinearLayout1;
    private Button mBtnTitle1, mBtnTitle2, mBtnTitle3, mBtnTitle4, mBtnTitle5, mBtnTitle6;
    private Button[] mArrayBtn = {mBtnTitle1, mBtnTitle2, mBtnTitle3, mBtnTitle4, mBtnTitle5, mBtnTitle6};
    private String[] mArrayTCTitle;
    private String[] mArraySCTitle;
    public static int contextIndex; //第幾篇經文
    static int ScreenWidth;
    static int ScreenHight;
    private SharedPreferences sp;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Init();
        setBtnText();

       // mAdView = (AdView) findViewById(R.id.adView);
       // AdRequest adRequest = new AdRequest.Builder().build();
       // mAdView.loadAd(adRequest);
    }

    private void Init() {
        LinearLayout1 = (LinearLayout) findViewById(R.id.LinearLayout1);
        mArrayBtn[0] = (Button) findViewById(R.id.btnTitle1);
        mArrayBtn[1] = (Button) findViewById(R.id.btnTitle2);
        mArrayBtn[2] = (Button) findViewById(R.id.btnTitle3);
        mArrayBtn[3] = (Button) findViewById(R.id.btnTitle4);
        mArrayBtn[4] = (Button) findViewById(R.id.btnTitle5);
        mArrayBtn[5] = (Button) findViewById(R.id.btnTitle6);
        mArrayTCTitle = getResources().getStringArray(R.array.tc_title);
        mArraySCTitle = getResources().getStringArray(R.array.sc_title);
        sp = getSharedPreferences("PREF_LOGIN",
                Context.MODE_PRIVATE);
        Setting.Language = sp.getString("language", "TC");
        Setting.fontSize = sp.getInt("fontsize", 20);
        // Toast.makeText(this,Setting.Language+","+Setting.fontSize ,Toast.LENGTH_LONG).show();

    }

    private void setBtnText() {
        switch (Setting.Language) {
            case "TC":

                for (int i = 0; i < mArrayBtn.length; i++) {
                    mArrayBtn[i].setText(mArrayTCTitle[i]);
                    mArrayBtn[i].setTextSize(Setting.fontSize);
                }
                break;
            case "SC":
                for (int i = 0; i < mArrayBtn.length; i++) {
                    mArrayBtn[i].setText(mArraySCTitle[i]);
                    mArrayBtn[i].setTextSize(Setting.fontSize);

                }

                break;
        }

    }

    //    public boolean onCreateOptionsMenu(Menu menu) {
//        super.onCreateOptionsMenu(menu);
//        /*建立選單*/
//        menu.add(0, 0, Menu.NONE, "設定/设定");
//        menu.add(0, 1, Menu.NONE, "關於/关于");
//        return true;
//
//    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        menu.add(0, 1, 0, "選單一");//groupid,itemid,order,選單名稱
//        menu.add(0, 2, 0, "選單二");
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
//        if (item.getGroupId() == 0) {
//            switch (item.getItemId()) {
//                case 0:
//                    Intent intent = new Intent(this, Setting.class);
//                    this.startActivity(intent);
//                    break;
//                case 1:
//                    Intent intent2 = new Intent(this, About.class);
//                    this.startActivity(intent2);
//                    break;
//
//            }
//        }
        switch (item.getItemId()) {
            case R.id.menu1:
                Intent intent = new Intent(this, Setting.class);
                this.startActivity(intent);
                break;

            case R.id.menu2:
                Intent intent2 = new Intent(this, About.class);
                this.startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void NextPage(View v) {
        switch (v.getId()) {
            case R.id.btnTitle1:
                contextIndex = 0;
                break;
            case R.id.btnTitle2:
                contextIndex = 1;
                break;
            case R.id.btnTitle3:
                contextIndex = 2;
                break;
            case R.id.btnTitle4:
                contextIndex = 3;
                break;
            case R.id.btnTitle5:
                contextIndex = 4;
                break;
            case R.id.btnTitle6:
                contextIndex = 5;
                break;
        }
        Intent in = new Intent(this, Context.class);
        startActivity(in);

    }
}
