package com.sec05;

import com.courseUtil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec03HotPublish {
    public static void main(String[] args) {
        //share() = publish().refCount(1)
        Flux<String> movieStream = Flux.fromStream(() -> getMovie())
                .delayElements(Duration.ofSeconds(2))
                //It is a connectable flux where multiple subscribers can connect to a flux
                .publish()
                //refCount is the minimum number of subscribers to publish data
                .refCount(1);

        movieStream
                .subscribe(Util.subscriber("Sam"));

        Util.sleepSeconds(5);

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
