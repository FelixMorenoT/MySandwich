package com.sandwich.core.app.pojo;

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
}
