package com.sec05;

import com.courseUtil.Util;
import com.sec05.Assignment.InventoryService;
import com.sec05.Assignment.OrderService;
import com.sec05.Assignment.RevenueService;

public class Lec06Assignment {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        RevenueService revenueService =  new RevenueService();
        InventoryService inventoryService = new InventoryService();

        //Revenue and Inventory observe the order stream
        orderService.orderStream().subscribe(revenueService.subscriberOrderStream());
        orderService.orderStream().subscribe(inventoryService.subscriberOrderStream());

        inventoryService.inventoryStream()
                .subscribe(Util.subscriber("inventory"));

        revenueService.revenueStream()
                .subscribe(Util.subscriber("revenue"));

        Util.sleepSeconds(60);
    }
}
