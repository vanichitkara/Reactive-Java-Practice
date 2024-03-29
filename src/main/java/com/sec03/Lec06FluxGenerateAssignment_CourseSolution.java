package com.sec03;

import com.courseUtil.Util;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

public class Lec06FluxGenerateAssignment_CourseSolution {
    public static void main(String[] args) {
        //Additional requirements
        //Canada - Exit
        //Emit max 10 countries
        //if subscriber cancels then exit
        AtomicInteger counter = new AtomicInteger();
        Flux.generate(synchronousSink -> {
            String country = Util.faker().country().name();
            System.out.println("Emitting " + country);
            synchronousSink.next(country);
            counter.getAndIncrement();
            if(country.equalsIgnoreCase("canada")){
                synchronousSink.complete();
            }
        })
        .take(10)
        .subscribe(Util.subscriber());
    }
}
