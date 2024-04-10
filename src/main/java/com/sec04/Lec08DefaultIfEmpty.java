package com.sec04;

import com.courseUtil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec08DefaultIfEmpty {
    public static void main(String[] args) {
        getOrderNumbers()
                .filter(i -> i>10)
                .defaultIfEmpty(-100)
                //Getting a default value in case the publisher doesn't emit anything
                .subscribe(Util.subscriber());
    }

    private static Flux<Integer> getOrderNumbers(){
        return Flux.range(1, 10);
    }
}
