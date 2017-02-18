package com.xpp.neo1.paperplane.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by neo1 on 2017/2/10.
 */

public class App extends Application {
    private static List<Activity> activityList = new LinkedList<>();

    @Override
    public void onCreate() {
        super.onCreate();
    }

    //获取栈顶activity
    public static Context getTopActivity() {
        return activityList.get(activityList.size() - 1);
    }

    //向容器中添加activity
    public static void addActivity(Activity activity) {
        activityList.add(activity);
    }

    //从容器中移除activity
    public static void removeActivity(Activity activity) {
        activityList.remove(activity);
    }
    //关闭所有的activity
    public static void finishedAllActivity(){
        try {
            for (Activity activity : activityList) {
                if (null != activity) {
                    activity.finish();
                }
            }
        } catch (Exception e) {
            Log.e("Exception", e + "");
        }
    }
}
