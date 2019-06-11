package com.chrislai.chris.amitofu2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class Setting extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    public static String Language="TC";
    public static int fontSize =20 ;
    private TextView mTvFontSize;
    private Spinner mSpinner ;
    private SeekBar mSeekBarDef;
    private SharedPreferences sp;
    private String[] x={"繁體中文","简体中文"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        init();
    }
    private void init() {
        mSpinner = (Spinner) findViewById(R.id.spinner);
        mSeekBarDef = (SeekBar) findViewById(R.id.seekbar_def);
        mTvFontSize = (TextView) findViewById(R.id.tvFontSize);
        ArrayAdapter<String> ada = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, x);
        ada.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(ada);
        mSpinner.setOnItemSelectedListener(l1);
        mSeekBarDef.setOnSeekBarChangeListener(this);
        mSeekBarDef.setProgress(fontSize);
        mTvFontSize.setTextSize(fontSize);

        //取得偏好資訊
        sp = getSharedPreferences("PREF_LOGIN",
                Context.MODE_PRIVATE);
        Language = sp.getString("language", "TC");
        fontSize = sp.getInt("fontsize", 20);
        Log.d("Language", Language);

        switch (Language) {
            case "TC":
                Log.d("Language", "0");
                mSpinner.setSelection(0, true);
                break;
            case "SC":
                Log.d("Language", "1");
                mSpinner.setSelection(1, true);
                break;
            default:
                Log.d("Language", "0");
                mSpinner.setSelection(0, true);
                break;

        }

    }
    /*
 * SeekBar停止滚动的回调函数
 */
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    /*
     * SeekBar开始滚动的回调函数
     */
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    /*
    * SeekBar滚动时的回调函数
    */
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress,
                                  boolean fromUser) {
        //mTvFontSize.setText(String.valueOf(seekBar.getId()));
        mTvFontSize.setTextSize(progress);
        fontSize = progress;

    }
    //下拉選單選擇ITEM的事件
    private   Spinner.OnItemSelectedListener l1 = new  Spinner.OnItemSelectedListener()
    {

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            String msg = adapterView.getSelectedItem().toString();
            switch (msg)
            {
                case"繁體中文":
                    Language ="TC";
                    break;
                case"简体中文":
                    Language="SC";
                    break;
            }

        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };
    public void onClick_Update(View v)
    {
        // 設定偏好編輯模式
        SharedPreferences.Editor edit = sp.edit();
        edit.putInt("fontsize", fontSize);
        edit.putString("language", Language);
        // 確認儲存
        edit.apply();
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);

    }
}
