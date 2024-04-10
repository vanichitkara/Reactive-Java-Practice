package com.sec04;

import com.courseUtil.Util;
import reactor.core.publisher.Flux;

public class Lec09SwitchIfEmpty {
    public static void main(String[] args) {
        getOrderNumbers()
                .filter(i -> i>10)
                .switchIfEmpty(fallback())
                //we can give a publisher with fallback items
                .subscribe(Util.subscriber());
    }

    private static Flux<Integer> getOrderNumbers(){
        return Flux.range(1, 10);
    }

    private static Flux<Integer> fallback(){
        return Flux.range(20, 5);
    }
}
