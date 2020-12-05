package com.example.manifestdeclaredreceivers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static TextView info;  //设置一个全局静态变量，可以由类名直接调用 MainActivity.info

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        info = findViewById(R.id.text);  //获取文本视图控件
        Button btn_sendBroadcast = findViewById(R.id.btn); //获取按钮视图控件
        btn_sendBroadcast.setOnClickListener(new View.OnClickListener() {  //为获取的按钮设置监听器 Listener，
            @Override
            public void onClick(View v) {    //当该按钮被点击时就会触发监听器并执行方法 onClick

                Intent intent = new Intent();  //定义一个意图 intent，用于触发希望接受该广播的广播接收器

//                下面是隐式调用意图的方法，该方法的字符串参数指定动作，经系统匹配后，
//                能过滤出该动作 action 的广播接受器将会接收广播，但只支持 API 不小于 26 的系统
                intent.setAction("com.example.MYRECEIVER");

                //显示指定广播接收器，该 ComponentName 构造函数的第一个参数是组件所在的包的包名，第二个是广播接收器的全限定类名
                intent.setComponent(new ComponentName("com.example.manifestdeclaredreceivers","com.example.manifestdeclaredreceivers.MyReceiver"));

                intent.putExtra("msg","this is a broadcast test"); //封装一条消息到 intent 中，广播接收器将会接收到该消息

                sendBroadcast(intent);  // 启动发送广播 启动广播接收器

            }
        });
    }
}