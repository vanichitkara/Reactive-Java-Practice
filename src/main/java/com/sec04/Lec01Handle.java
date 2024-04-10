package com.sec04;

import com.courseUtil.Util;
import reactor.core.publisher.Flux;

public class Lec01Handle {
    public static void main(String[] args) {
        //handle = map+filter
        Flux.range(1, 20)
                .handle((integer, synchronousSink) -> {
                    if(integer%2==0){
                        synchronousSink.next(integer); //filter
                    }
                    else{
                        synchronousSink.next(integer + "a"); //map
                    }
                    if(integer==9){
                        synchronousSink.complete();
                    }
                })
                .subscribe(Util.subscriber());
    }
}
