package com.sec01;

import com.courseUtil.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class Lec05MonoFromSupplier {
    public static void main(String[] args) {
        //use just only when you have data already
        //Mono<String> mono = Mono.just(getName());

        //Use supplier when you don't expect any error
        Supplier<String> stringSupplier = () -> getName();
        Mono<String> mono = Mono.fromSupplier(stringSupplier);
        mono.subscribe(
                Util.onNext()
        );

        //Callable can return an error as well
        Callable<String> stringCallable = () -> getName();
        Mono.fromCallable(stringCallable)
                .subscribe(Util.onNext());
    }

    private static String getName(){
        System.out.println("Generating name..");
        return Util.faker().name().fullName();
    }
}
