package com.sec03;

import com.courseUtil.Util;
import reactor.core.publisher.Flux;

import java.util.Objects;

public class Lec06FluxGenerateAssignment_MySolution {
    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
            String country="Canada";
            if(Objects.equals(Util.faker().country().name(), country)){
                synchronousSink.complete();
            }
            synchronousSink.next(Util.faker().country().name());
        }).subscribe(Util.subscriber());
    }
}
