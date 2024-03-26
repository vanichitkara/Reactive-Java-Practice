package com.sec02;

import com.courseUtil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec08FluxInterval {
    public static void main(String[] args) {
        //this is unlike Util.sleep where we are blocking a thread.
        //Flux interval is used to publish data periodically
        Flux.interval(Duration.ofSeconds(1))
            .subscribe(Util.onNext());

        Util.sleepSeconds(5);
    }
}
