package com.sec05;

import com.courseUtil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec02HotShare {
    public static void main(String[] args) {
        //It'll act like TV show now
        Flux<String> movieStream = Flux.fromStream(() -> getMovie())
                .delayElements(Duration.ofSeconds(2))
                .share();

        //Sam is watching movie on TV
        movieStream
                .subscribe(Util.subscriber("Sam"));

        Util.sleepSeconds(5);

        //Mike joins watching the movie on TV and misses some starting scenes
        movieStream
                .subscribe(Util.subscriber("Mike"));

        Util.sleepSeconds(60);
    }

    private static Stream<String> getMovie(){
        System.out.println("Got the movie streaming request");
        return Stream.of(
                "Scene 1",
                "Scene 2",
                "Scene 3",
                "Scene 4",
                "Scene 5",
                "Scene 6",
                "Scene 7"
        );
    }
}
