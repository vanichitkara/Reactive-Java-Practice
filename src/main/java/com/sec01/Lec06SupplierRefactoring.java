package com.sec01;

import com.courseUtil.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class Lec06SupplierRefactoring {
    public static void main(String[] args) {
        //Calling getName() creates a pipeline, but subscribing to the function
        //executes the pipeline containing the business logic
        getName();
        String name = getName().subscribeOn(Schedulers.boundedElastic())
                .block();
        System.out.println(name);
        getName();

        Util.sleepSeconds(4);
    }
    private static Mono<String> getName(){
        System.out.println("entered getName method");
        return Mono.fromSupplier(() -> {
                System.out.println("Generating name..");
            Util.sleepSeconds(3);
            return Util.faker().name().fullName();
            }).map(String::toUpperCase);
    }
}
