package com.sec01;

import com.courseUtil.Util;
import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {
    public static void main(String[] args) {
        //Mono won't emit anything unless we subscribe to it
        Mono<Integer> mono = Mono.just("ball")
                                .map(String::length)
                                .map(l -> l);
        //mono.subscribe();
        mono.subscribe(
            Util.onNext(),
            Util.onError(),
            Util.onComplete()
        );
    }
}
