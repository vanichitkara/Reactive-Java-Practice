package com.sec03;

import com.courseUtil.Util;
import com.sec03.helper.NameProducer;
import reactor.core.publisher.Flux;

public class Lec02FluxCreateRefactor {
    public static void main(String[] args) {
        NameProducer nameProducer = new NameProducer();
        Flux.create(nameProducer)
                .subscribe(Util.subscriber());
        //FluxSink is thread safe, and we can share flux sink with multiple threads to emit items
        Runnable runnable = nameProducer::produce;
        for(int i=0; i<10; i++){
            new Thread(runnable).start();
        }
    }
}
