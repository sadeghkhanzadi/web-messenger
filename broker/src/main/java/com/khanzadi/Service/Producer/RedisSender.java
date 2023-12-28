package com.khanzadi.Service.Producer;

import com.khanzadi.dto.message.MessageDto;
import com.khanzadi.exeption.MessengerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

@Service
public class RedisSender {
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisSender.class);

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private ChannelTopic topic;

    public void sendDataToRedisQueue(MessageDto input) throws MessengerException {
        try {
            redisTemplate.convertAndSend(topic.getTopic(), input);
            LOGGER.info("Data - " + input + " sent through Redis Topic - " + topic.getTopic());
        } catch (Exception e){
            throw new MessengerException(e.getMessage());
        }
    }
}
