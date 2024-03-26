package com.sec01;

import com.courseUtil.Util;
import reactor.core.publisher.Mono;

public class Lec08MonoFromRunnable {
    public static void main(String[] args) {
        //Use Runnable when you want to get notified about a process getting completed
        //And then start another process
        //Mono.fromRunnable gives only onComplete signal
        Mono.fromRunnable(timeConsumingProcess())
                .subscribe(Util.onNext(),
                        Util.onError(),
                        () -> {
                            System.out.println("Process done, sending emails...");
                        });
    }

    private static Runnable timeConsumingProcess(){
        return () -> {
            Util.sleepSeconds(3);
            System.out.println("Operations completed");
        };
    }
}
