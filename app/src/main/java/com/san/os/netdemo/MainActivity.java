package com.san.os.netdemo;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.HttpAuthHandler;
import android.widget.Button;
import android.widget.TextView;

import com.san.os.netdemo.net.HttpUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTextView;
    private Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.text);
        mBtn = (Button) findViewById(R.id.button);

        mBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        new MyAysnTask().execute(Urls.teaURL);
    }

    class MyAysnTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... param) {
            if (param != null) {
                String url = param[0];

                String reslt = HttpUtils.getStringReslutFromNet(url);
                return reslt;
            }

            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            mTextView.setText(TextUtils.isEmpty(result) ? "null" : result);
            super.onPostExecute(result);
        }
    }


}
