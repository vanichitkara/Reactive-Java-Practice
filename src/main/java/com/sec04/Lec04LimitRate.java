package com.sec04;

import com.courseUtil.Util;
import reactor.core.publisher.Flux;

public class Lec04LimitRate {
    public static void main(String[] args) {
        //limitRate sends in request after 75% of the data is emitted
        Flux.range(1, 1000)
                .log()
                //we can change the % value by sending a lowTide parameter
                //if highTide==lowTide, lowTide is 75 by default
                //if we want to consume all data before sending data again, keep lowTide as 0
                .limitRate(100, 99)
                .subscribe(Util.subscriber());
    }
}
