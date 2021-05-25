package com.sandwich.core.app.pojo;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StandardReponse {

	private Integer responseCode;
	private String responseStatus;
	private String responseMsg;
	
	public StandardReponse getReponse (Integer codeResponse, String msg) {
		return StandardReponse.builder()
				.responseCode(HttpStatus.valueOf(codeResponse).value())
				.responseStatus(HttpStatus.valueOf(codeResponse).name())
				.responseMsg(msg)
				.build();
	}
}
