package com.ayuan.dyncaddfragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取手机的分辨率
        WindowManager windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display defaultDisplay = windowManager.getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        //手机的宽
        int width = point.x;
        //手机的高
        int height = point.y;
        //获取Fragment的管理者
        FragmentManager fragmentManager = getFragmentManager();
        //开启一个事务
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //判断横竖屏
        if (height > width) {
            //竖屏状态   android.R.id.content可以理解为当前手机的窗体
            fragmentTransaction.replace(android.R.id.content, new Fragment1());
        } else {
            //横屏状态
            fragmentTransaction.replace(android.R.id.content, new Fragment2());
        }
        //一定要记得提交
        fragmentTransaction.commit();
    }
}
