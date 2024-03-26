package com.sec01;

import com.courseUtil.Util;
import reactor.core.publisher.Mono;

public class Lec04MonoEmptyOrError {
    public static void main(String[] args) {
        //Mono generally gives onNext and onComplete signals
        //Mono.empty() gives only onComplete signal
        //Mono.error() gives only onError signal
        userRepository(1)
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );
    }

    private static Mono<String> userRepository(int userId){
        if(userId == 1){
            return Mono.just(Util.faker().name().firstName());
        }else if(userId == 2){
            return Mono.empty();
        }else{
            return Mono.error(new RuntimeException("Not in the allowed range"));
        }
    }
}
