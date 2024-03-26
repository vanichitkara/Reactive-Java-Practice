package com.sec02;

import com.courseUtil.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class Lec03FluxFromArrayOrList {
    public static void main(String[] args) {
        List<String> string = Arrays.asList("a", "b", "c", "d");

        //Similar to Flux.just
        Flux.fromIterable(string)
                .subscribe(Util.onNext());

        Integer[] arr = {2,4,5,7};
        Flux.fromArray(arr)
                .subscribe(Util.onNext());
    }
}
