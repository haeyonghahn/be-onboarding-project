package com.onboarding.servey.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Option {

	private Long optionId;
	private int number;

	public static Option generateOption(
		OptionId optionId,
		OptionNumber optionNumber) {
		return new Option(
			optionId.optionId,
			optionNumber.numberValue);
	}

	@Value
	public static class OptionId {
		Long optionId;

		public OptionId(Long optionId) {
			this.optionId = optionId;
		}
	}

	@Value
	public static class OptionNumber {
		int numberValue;

		public OptionNumber(int value) {
			this.numberValue = value;
		}
	}
}
