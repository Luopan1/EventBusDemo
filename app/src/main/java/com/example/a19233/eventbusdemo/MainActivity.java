package com.example.a19233.eventbusdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    private Button mSend;
    private Button mSendx;
    private TextView mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        setListener();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (EventBus.getDefault().isRegistered(this)){
            return;
        }
        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void BeanEventBus(Bean bean){
        /**显示消息*/
        mResult.setText(bean.toString());

    }

    private void setListener() {
        mSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //发送消息
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }
        });
        mSendx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().postSticky(new Bean("粘性事件","1213145","2017 4 22"));

                startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }
        });
    }

    private void initView() {
        mSend = (Button) findViewById(R.id.send);
        mSendx = (Button) findViewById(R.id.sendx);
        mResult = (TextView) findViewById(R.id.result);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
