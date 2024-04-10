package com.sec04;

import com.courseUtil.Util;
import reactor.core.publisher.Flux;

public class Lec02HandleAssignment {
    public static void main(String[] args) {
        Flux.generate(synchronousSink -> synchronousSink.next(Util.faker().country().name()))
                .map(Object::toString)
                .handle((s, synchronousSink) -> {
                    synchronousSink.next(s);
                    if(s.equalsIgnoreCase("canada")){
                        synchronousSink.complete();
                    }
                })
                .subscribe(Util.subscriber());
    }
}
