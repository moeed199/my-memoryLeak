package com.example.findingmemoryleak;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/* -since its extend to application it is equivalent to context class
   -this class is context aware of whole application
   -if this class is not registered in manisfest file it won't be loaded at app launch
   -there can be only one application instance for an app
   -variables in application are accesible pplication wide
    */

public class MyCustomApplication extends Application {

    private RefWatcher refWatcher;
    public static RefWatcher getRefWatcher(Context context){
        MyCustomApplication myCustomApplication = (MyCustomApplication) context.getApplicationContext();
        return myCustomApplication.refWatcher;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        refWatcher = LeakCanary.install(this);
    }
}
