package com.example.findingmemoryleak;

import android.content.Context;

public class SomeRandomSampleClass {

    private static SomeRandomSampleClass someRandomSampleClassInstance;
    private Context context;

    private SomeRandomSampleClass(Context context){//private constructor will make ensure that no outside class can create instance of this class
        this.context = context;
    }

    public static SomeRandomSampleClass getSomeRandomSampleClassInstance(Context context){
        if (someRandomSampleClassInstance == null){
              someRandomSampleClassInstance = new SomeRandomSampleClass(context);
        }
        return someRandomSampleClassInstance;
    }
}
