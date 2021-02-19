package com.letskodeit.teachable.listenerspackage;

import org.testng.*;

public class CustomListener3 implements ISuiteListener {


    @Override
    public void onStart(ISuite suite) {
        System.out.println(">>>>> SUITE Listener --- onStart: " + suite.getName());
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println(">>>>> SUITE Listener --- onFinish: " + suite.getName());
    }
}
