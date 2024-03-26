package com.sec02;

import com.courseUtil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec09FluxFromMono {
    public static void main(String[] args) {
        //Create flux from Mono
//        Mono<String> mono = Mono.just("a");
//        Flux<String> flux = Flux.from(mono);
//        flux.subscribe(Util.onNext());

        //Create Mono from Flux - we'll only get a single item from this
        Flux.range(1, 10)
                .filter(i -> i>3) //Get the next item greater than 3
                .next() //The first item that goes through this is emitted
                .subscribe(Util.onNext(),
                        Util.onError(),
                        Util.onComplete());
    }
}
