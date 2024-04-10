package com.sec02.helper;

import reactor.core.publisher.Flux;

public class UserService {
    public static Flux<User> gteUsers(){
        return Flux.range(1, 2)
                .map(i -> new User(i));
    }
}
