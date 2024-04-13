package com.sec05;

import com.courseUtil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec01ColdPublisher {
    public static void main(String[] args) {
        Flux<String> movieStream = Flux.fromStream(() -> getMovie())
                .delayElements(Duration.ofSeconds(2));

        //Sam is playing movie from Netflix
        movieStream
                .subscribe(Util.subscriber("Sam"));

        Util.sleepSeconds(5);

        //Mike is playing the same movie from Netflix simultaneously
        movieStream
                .subscribe(Util.subscriber("Mike"));

        Util.sleepSeconds(60);
    }

    //It'll act like netflix
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
