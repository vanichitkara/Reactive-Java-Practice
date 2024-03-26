package com.sec03;

import com.courseUtil.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxCreate {
    public static void main(String[] args) {
        //Flux.create() can help create a do-while loop kind of behaviour
        //to keep on emitting items till a condition is met
        Flux.create(fluxSink -> {
            String country;
            do{
                country=Util.faker().country().name();
                fluxSink.next(country);
            }
            while(!country.equalsIgnoreCase("canada"));
            fluxSink.complete();
        })
        .subscribe(Util.subscriber());
    }
}
