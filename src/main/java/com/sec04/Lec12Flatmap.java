package com.sec04;

import com.courseUtil.Util;
import com.sec02.helper.OrderService;
import com.sec02.helper.UserService;

public class Lec12Flatmap {
    public static void main(String[] args) {
        UserService.gteUsers()
                //getting flux returned in the pipeline when using map
                .flatMap(user -> OrderService.getOrder(user.getUserId())) //using flatmap gets us the PurchaseOrder object
                //flatMap subscribes to the internal flux objects
                .subscribe(Util.subscriber());
        // to move to other publisher after one publisher emits all objects, use concatMap
    }
}
