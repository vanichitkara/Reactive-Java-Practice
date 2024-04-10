package com.sec04;

import com.courseUtil.Util;
import com.sec02.helper.Person;
import reactor.core.publisher.Flux;

import java.util.Objects;
import java.util.function.Function;

public class Lec11SwitchOnFirst {
    public static void main(String[] args) {
        getPerson()
                .switchOnFirst((signal, personFlux) -> {
                    System.out.println("Inside switch on first");
                   return signal.isOnNext() && Objects.requireNonNull(signal.get()).getAge() >10 ? personFlux : applyFilterMap().apply(personFlux);
                })
                .subscribe(Util.subscriber());
    }

    public static Flux<Person> getPerson(){
        return Flux.range(1, 10)
                .map(i -> new Person());
    }

    public static Function<Flux<Person>, Flux<Person>> applyFilterMap(){
        return flux -> flux
                .filter(p -> p.getAge()>10)
                .doOnNext(p -> p.setName(p.getName().toUpperCase()))
                .doOnDiscard(Person.class, p -> System.out.println("Not allowing: " + p));
    }
}
