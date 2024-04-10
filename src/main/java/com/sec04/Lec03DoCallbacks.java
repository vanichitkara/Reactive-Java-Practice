package com.sec04;

import com.courseUtil.Util;
import reactor.core.publisher.Flux;

import static java.lang.System.err;

public class Lec03DoCallbacks {
    public static void main(String[] args) {
        //subscription callback goes from top to bottom - as the subscription comes from publisher to subscriber
        //doFirst callback goes from bottom to top - subscriber requests to publisher and starts executing upwards from
        //bottom to top
        Flux.create(fluxSink -> {
            System.out.println("inside create");
            for(int i=0; i<5; i++){
                fluxSink.next(i);
            }
            fluxSink.error(new RuntimeException("oops"));
            System.out.println("--completed");
        })
        .doOnComplete(() -> System.out.println("doOnComplete"))
        .doFirst(() -> System.out.println("doFirst"))
        .doOnNext(o ->System.out.println("doOnNext: " + o))
        .doOnSubscribe(s -> System.out.println("doOnSubscribe: " + s))
        .doOnRequest(l -> System.out.println("doOnRequest: " + l))
        .doOnError(err -> System.out.println("doOnError: " + err.getMessage()))
        .doOnTerminate(() -> System.out.println("doOnTerminate"))
        .doOnCancel(() -> System.out.println("doOnCancel"))
        .doFinally(signal -> System.out.println("doFinally 1: " + signal))
        .doOnDiscard(Object.class, o -> System.out.println("doOnDiscard: " + o))
        .take(2) //this doesn't execute the doOnTerminate callback
        .doFinally(signal -> System.out.println("doFinally 2: " + signal))
        .subscribe(Util.subscriber());
    }
}
