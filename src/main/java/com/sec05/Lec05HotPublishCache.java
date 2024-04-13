package com.sec05;

import com.courseUtil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec05HotPublishCache {
    public static void main(String[] args) {
        //cache = publish().replay()
        Flux<String> movieStream = Flux.fromStream(() -> getMovie())
                .delayElements(Duration.ofSeconds(1))
                //The cache stores the already emitted objects and gives it immediately to the next subscriber
                .cache(2);

        //Passing a number to cache would mean that it stores the last n objects only

        Util.sleepSeconds(2);

        movieStream
                .subscribe(Util.subscriber("Sam"));

        Util.sleepSeconds(10);

        System.out.println("Mike is about to join");

        movieStream
                .subscribe(Util.subscriber("Mike"));

        Util.sleepSeconds(60);
    }

    //movie theater
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
