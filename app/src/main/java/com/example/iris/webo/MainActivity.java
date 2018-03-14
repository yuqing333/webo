package com.example.iris.webo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.auth.AuthInfo;

import static com.example.iris.webo.Constants.APP_KEY;
import static com.example.iris.webo.Constants.REDIRECT_URL;
import static com.example.iris.webo.Constants.SCOPE;

public class MainActivity extends AppCompatActivity {
    private AuthInfo mAuthInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuthInfo=new AuthInfo(this,APP_KEY,REDIRECT_URL,SCOPE);
        WbSdk.install(this,mAuthInfo);

    }

    public void oauth(View view){
        Intent intent=new Intent(MainActivity.this,WBAuthActivity.class);
        startActivity(intent);
    }
}
