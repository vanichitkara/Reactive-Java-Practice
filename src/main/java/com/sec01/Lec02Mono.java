package com.sec01;

import reactor.core.publisher.Mono;

public class Lec02Mono {
    public static void main(String[] args) {
        Mono<Integer> mono = Mono.just(1);
        System.out.println(mono);
        mono.subscribe(i -> System.out.println("Received: " + i));
    }
}
