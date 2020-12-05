package com.example.manifestdeclaredreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver { //自定义的 broadcast 必须继承抽象类 BroadcastReceiver
    @Override
    public void onReceive(Context context, Intent intent) {  //参数 intent 中封装了广播的内容
        String msg = intent.getStringExtra("msg"); //获取广播内容
        MainActivity.info.setText(msg);  //重新设置主活动 activity_main.xml 中文本视图的内容
        Log.d(intent.getAction(),intent.getStringExtra("msg")); //在控制台打印广播信息
    }
}
