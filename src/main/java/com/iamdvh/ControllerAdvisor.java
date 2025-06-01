package com.iamdvh;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.iamdvh.dto.ResponseDTO;
import com.iamdvh.exception.FieldRequiredException;

@ControllerAdvice
public class ControllerAdvisor {
	
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<ResponseDTO> handleArithmicException(ArithmeticException e , WebRequest request) {
		ResponseDTO result = new ResponseDTO();
		result.setError(e.getMessage());
		List<String> details = new ArrayList<>();
		details.add("Anh gì ơi, thế quái nào mà 1 số có thể chia cho 0 được nhỉ.");
		result.setDetails(details);
		return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(FieldRequiredException.class)
	public ResponseEntity<ResponseDTO> handleFieldRequiredException(FieldRequiredException e , WebRequest request) {
		ResponseDTO result = new ResponseDTO();
		result.setError(e.getMessage());
		List<String> details = new ArrayList<>();
		details.add("Tao bảo là field require mà.");
		result.setDetails(details);
		return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
	}

}
