package com.example.iris.webo;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.auth.WbConnectErrorMessage;
import com.sina.weibo.sdk.auth.sso.SsoHandler;

import static com.example.iris.webo.Constants.*;

public class WBAuthActivity extends Activity {

    private static final String TAG="weibosdk";
    //显示认证后的信息
    private TextView mTokenText;
    //封装了"access_token"，"expires_in"，"refresh_token"，并提供了他们的管理功能
    private Oauth2AccessToken mAccessToken;
    //注意：SsoHandler 仅当 SDK 支持 SSO 时有效
    private SsoHandler mSsoHandler;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wbauth);

        mSsoHandler=new SsoHandler(WBAuthActivity.this);
        findViewById(R.id.obtain_token_via_web).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSsoHandler.authorizeWeb(new WbAuthListener() {
                    @Override
                    public void onSuccess(Oauth2AccessToken oauth2AccessToken) {
                        Toast.makeText(getParent(), "success", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void cancel() {

                    }

                    @Override
                    public void onFailure(WbConnectErrorMessage wbConnectErrorMessage) {

                    }
                });
            }
        });

    }
}
