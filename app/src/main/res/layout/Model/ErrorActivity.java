package com.rosenta.standard.Model;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.rosenta.standard.MainActivity;
import com.rosenta.standard.R;

import tr.xip.errorview.ErrorView;

public class ErrorActivity extends AppCompatActivity {

    static {
        AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_AUTO);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error);

        final ErrorView mErrorView = (ErrorView) findViewById(R.id.error_view);
        mErrorView.setTitle(R.string.error_title_damn)
                .setTitleColor(getResources().getColor(R.color.colorPrimary))
                .setSubtitle(R.string.error_subtitle_failed_one_more_time)
                .setRetryText(R.string.report)
                .setImage(R.drawable.sadface);

        mErrorView.setRetryListener(new ErrorView.RetryListener() {
            @Override
            public void onRetry() {
                Toast.makeText(com.rosenta.standard.Model.ErrorActivity.this, R.string.info_retrying, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);

                /*new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                    }
                }, 0);*/
            }
        });
    }
}