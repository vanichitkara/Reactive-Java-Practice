package com.sec03;

import com.courseUtil.Util;
import reactor.core.publisher.Flux;

public class Lec03FluxTake {
    public static void main(String[] args) {
        //Take limits the subscription till the integer it takes
        //and cancels the subscription as soon as we get the integer
        Flux.range(1, 10)
                .log()
                .take(3)
                .log()
                .subscribe(Util.subscriber());
    }
}
