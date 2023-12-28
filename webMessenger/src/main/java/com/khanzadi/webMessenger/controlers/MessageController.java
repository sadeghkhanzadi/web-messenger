package com.khanzadi.webMessenger.controlers;

import com.khanzadi.Controller.RedisController;
import com.khanzadi.dto.message.MessageDto;
import com.khanzadi.exeption.MessengerException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.khanzadi.constans.UriConstants.MS_SENDER_MESSAGE;

@RestController
@RequestMapping("/api/v1")
public class MessageController {
    @PostMapping(MS_SENDER_MESSAGE)
	public String sendDataToRedisQueue(@RequestBody MessageDto input) throws MessengerException {
        RedisController.sendDataToRedisQueue(input);
		return "successfully sent";
	}
}
