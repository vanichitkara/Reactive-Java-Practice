package com.sec03;

import com.courseUtil.Util;
import reactor.core.publisher.Flux;

public class Lec04FluxCreateIssueFix {
    public static void main(String[] args) {
        //only one instance of flux sink is shared with multiple threads
        Flux.create(fluxSink -> {
            String country;
            do{
                country= Util.faker().country().name();
                System.out.println("Emitting: " + country);
                fluxSink.next(country);
            }
            //It will emit items till it gets country as Canada or the subscription is cancelled due to take operator
            while(!country.equalsIgnoreCase("canada") && !fluxSink.isCancelled());
            fluxSink.complete();
        })
        //The subscriber only gets the first 3 countries
        .take(3)
        .subscribe(Util.subscriber());
    }
}
