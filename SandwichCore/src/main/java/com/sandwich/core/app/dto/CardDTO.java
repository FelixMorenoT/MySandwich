package com.sandwich.core.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardDTO {

	private String cardOwnerFullName;
	private String cardNumer;
	private int cardMothExpired;
	private int cardYearExpiredDate;
	private String cardCVV;
}
