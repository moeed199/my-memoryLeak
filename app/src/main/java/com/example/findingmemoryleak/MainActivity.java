package com.example.findingmemoryleak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.squareup.haha.perflib.Main;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    SomeRandomSampleClass someRandomSampleClass;

    private static WeakReference<MainActivity> mainActivity;
    private static TextView textView;
    private static Object innerObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        someRandomSampleClass = SomeRandomSampleClass.getSomeRandomSampleClassInstance(this);// this line willl cause memory leak becuause we are passing activity context
                                                                                            //it has static reference of context
        mainActivity = new WeakReference<MainActivity>(this);
        textView = findViewById(R.id.textView); //this view is part of activity may lead to memory leak,as it hold the reference of particular activity

        class SampleInnerClass{

        }
        innerObject = new SampleInnerClass();//this will have activity refrence may lead to memory leak(dont use static inner class refrence
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        textView = null; //this will avoid memory leak
    }
}

/*by using getApplicationContext it doesn't result in meory leak because you are not getting new instacnces of application
* every time activity gets created due to screen rotation  no new instances of context are getting created
* Application object is singleton hence there will be only one contextImplementaion for application
* there can be multiple instances of same activity,each with their own contextImplemnetation
* */