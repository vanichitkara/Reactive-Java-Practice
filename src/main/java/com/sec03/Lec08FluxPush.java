package com.sec03;

import com.courseUtil.Util;
import com.sec03.helper.NameProducer;
import reactor.core.publisher.Flux;

public class Lec08FluxPush {
    public static void main(String[] args) {
        NameProducer nameProducer = new NameProducer();
        //Flux push is not thread safe, cannot share with multiple threads
        Flux.push(nameProducer)
                .subscribe(Util.subscriber());
        //Some threads will be missing when running this loop
        Runnable runnable = nameProducer::produce;
        for(int i=0; i<10; i++){
            new Thread(runnable).start();
        }
    }
}
