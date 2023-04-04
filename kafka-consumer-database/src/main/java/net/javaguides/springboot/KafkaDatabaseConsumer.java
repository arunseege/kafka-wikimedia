package net.javaguides.springboot;

import net.javaguides.springboot.entity.WikiMediaData;
import net.javaguides.springboot.repository.WikimediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);
private WikimediaDataRepository repository;

    public KafkaDatabaseConsumer(WikimediaDataRepository repository) {
        this.repository = repository;
    }

    @KafkaListener(topics = "wikimedia_recentchange",groupId = "myGroup")
    public void consume(String  eventMessage){
        LOGGER.info(String.format("Event Message received --> %s",eventMessage));
        WikiMediaData data = new WikiMediaData();
        data.setWikiEventData(eventMessage);
        repository.save(data);
    }

}
