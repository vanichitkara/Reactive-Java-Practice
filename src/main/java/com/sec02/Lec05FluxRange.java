package com.sec02;

import com.courseUtil.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxRange {
    //Used as a for loop, starts from the number given in first element
    //and prints the number of times mentioned in second parameter
    //For e.g., this function below prints the names 10 times
    public static void main(String[] args) {
        Flux.range(3, 10)
                .log()
                .map(i -> Util.faker().name().fullName())
                .log()
                .subscribe(Util.onNext());
    }
}
