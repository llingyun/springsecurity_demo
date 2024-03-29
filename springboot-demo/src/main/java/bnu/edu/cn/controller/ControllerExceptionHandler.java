package bnu.edu.cn.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import bnu.edu.cn.exception.UserNotExistException;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(UserNotExistException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Map<String, Object> handlerUserNotExistException(UserNotExistException ex) {
		Map<String, Object> map = new HashMap<>();
		map.put("message", ex.getMessage());
		map.put("id", ex.getId());
		return map;
	}
}
