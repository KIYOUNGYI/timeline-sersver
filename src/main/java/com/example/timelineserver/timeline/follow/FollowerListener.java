package com.example.timelineserver.timeline.follow;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FollowerListener {

    private final ObjectMapper objectMapper;
    private final FollowerStore followerStore;

    public FollowerListener(ObjectMapper objectMapper, FollowerStore followerStore) {
        this.objectMapper = objectMapper;
        this.followerStore = followerStore;
    }

    @KafkaListener(topics = "user.follower", groupId = "timeline-server")
    public void listen(String message) {

        log.info("FollowerListener.listen :" + message);

        try {
            FollowMessage followMessage = objectMapper.readValue(message, FollowMessage.class);
            followerStore.followUser(followMessage);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

}
