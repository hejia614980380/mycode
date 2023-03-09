package com.hejia.bean;

import org.springframework.context.LifecycleProcessor;

public class LifecycleObject implements LifecycleProcessor {
    @Override
    public void onRefresh() {
        System.out.println("onRefresh");
    }

    @Override
    public void onClose() {
        System.out.println("onClose");
    }

    @Override
    public void start() {
        System.out.println("start");
    }

    @Override
    public void stop() {
        System.out.println("stop");
    }

    @Override
    public boolean isRunning() {
        return false;
    }
}
