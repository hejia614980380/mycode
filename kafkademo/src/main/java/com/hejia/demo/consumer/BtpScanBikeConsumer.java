package com.hejia.demo.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;



@Component
public class BtpScanBikeConsumer {

    // Scan bike
    @KafkaListener(groupId = "all-field-scan-bike-fs-cc", topics = "af_foshan_cc_bike_event")
    public void networkPileInfo(ConsumerRecord<Object, Object> record) {
        System.out.println("dev-gw btp data: " + record.value());


    }
}