package com.sec01;

import com.courseUtil.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class Lec07MonoFromFuture {
    //Returns data asynchronously
    public static void main(String[] args) {
        Mono.fromFuture(getName())
                .subscribe(Util.onNext());

        Util.sleepSeconds(1);
    }

    private static CompletableFuture<String> getName(){
        return CompletableFuture.supplyAsync(() -> Util.faker().name().fullName());
    }
}
