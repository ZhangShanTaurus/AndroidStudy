// MyAIDLService.aidl
package com.android.example;

// Declare any non-default types here with import statements

interface MyAIDLService {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

    /**
     * return: a+b
     * */
    int add(int a,int b);
    /**
    * return:str
    * */
    String say(String str);
}
