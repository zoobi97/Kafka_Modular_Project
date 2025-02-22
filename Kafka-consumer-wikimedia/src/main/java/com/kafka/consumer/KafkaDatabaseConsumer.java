package com.kafka.consumer;

import com.kafka.consumer.Entity.WikimediaData;
import com.kafka.consumer.Repository.WikimediaDataRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);
    private WikimediaDataRepo dataRepo;

    public KafkaDatabaseConsumer(WikimediaDataRepo dataRepo) {
        this.dataRepo = dataRepo;
    }

    @KafkaListener(topics = "wikimedia_recentchange",groupId = "myGroup")
    public void consumer(String message){
        LOGGER.info(String.format("Event Message received -> %s",message));

        WikimediaData wikimediaData = new WikimediaData();
        wikimediaData.setWikiEventData(message);

        dataRepo.save(wikimediaData);
    }
}
