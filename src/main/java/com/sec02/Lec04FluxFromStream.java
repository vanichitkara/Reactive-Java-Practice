package com.sec02;

import com.courseUtil.Util;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Stream;

public class Lec04FluxFromStream {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4,5);
        Stream<Integer> stream = list.stream();
        //Stream can only be accessed once
//        stream.forEach(System.out::println);
//        stream.forEach(System.out::println);
//        Flux<Integer> integerFlux = Flux.fromStream(stream);

        //Need to create stream in the supplier itself to avoid single usage of stream
        Flux<Integer> integerFlux = Flux.fromStream(() -> list.stream());
        integerFlux.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
        //This stream will get error as the above stream already consumed the data
        integerFlux.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );


    }
}
