package com.sec04;

import com.courseUtil.Util;
import reactor.core.publisher.Flux;
import reactor.util.concurrent.Queues;

import java.time.Duration;

public class Lec05Delay {
    public static void main(String[] args) throws InterruptedException {
        //the publisher and subscriber in different threads, thus subscriber sends request for only 32 items
        //delay causes internal limitRate, the subscriber didn't even consume the already emitted items due to delay
        //The Queues class for reactor has a default buffer size of 32
        System.setProperty("reactor.bufferSize.x", "9"); //setting the bufferSize to 9
        Flux.range(1, 100)
                .log()
                .delayElements(Duration.ofSeconds(1))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }
}
