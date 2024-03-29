package com.sec03;

import com.courseUtil.Util;
import reactor.core.publisher.Flux;

import java.util.Objects;

public class Lec05FluxGenerate {
    public static void main(String[] args) {
        //The generate method invokes the synchronous sink, and we get into infinite loop situation
        //We get multiple instances of synchronous sink due to the generate method
        Flux.generate(synchronousSink -> {
            System.out.println("Emitting");
            synchronousSink.next(Util.faker().country().name());
            //We can only emit one item using synchronous sink
            //synchronousSink.next(Util.faker().country().name());
            //synchronousSink.error(new RuntimeException("oops"));
            synchronousSink.complete(); //This will limit the item to 1 even though we ask for 2 items in take
        })
                .take(2)
                .subscribe(Util.subscriber());
    }
}
