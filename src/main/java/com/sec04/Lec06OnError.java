package com.sec04;

import com.courseUtil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec06OnError {
    public static void main(String[] args) {
        Flux.range(1, 10)
                .log()
                .map(i -> 10/(5-i))
                //.onErrorReturn(-1) It gives a fallback value
                //.onErrorResume(e -> fallback()) It gives a random fallback value
                .onErrorContinue((err, obj) -> {
                    //This continues the loop even after error is encountered
                })
                .subscribe(Util.subscriber());
    }

    private static Mono<Integer> fallback(){
        return Mono.fromSupplier(() -> Util.faker().random().nextInt(100, 200));
    }
}
