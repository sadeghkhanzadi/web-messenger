package com.khanzadi.Controller;

import com.khanzadi.Service.Producer.RedisSender;
import com.khanzadi.dto.message.MessageDto;
import com.khanzadi.exeption.MessengerException;

public class RedisController {
	private static RedisSender sender;

	public static void sendDataToRedisQueue(MessageDto input) throws MessengerException {
		sender.sendDataToRedisQueue(input);
	}
}