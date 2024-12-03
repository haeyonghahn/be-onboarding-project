package com.onboarding.servey.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Servey {

	private Long serveyId;
	private String name;
	private String description;
	private List<Question> questions;

	public static Servey generateServey(
		ServeyId serveyId,
		ServeyName serveyName,
		ServeyDescription serveyDescription,
		ServeyQuestion serveyQuestion) {
		return new Servey(
			serveyId.serveyId,
			serveyName.nameValue,
			serveyDescription.descriptionValue,
			serveyQuestion.questionValue);
	}

	@Value
	public static class ServeyId {
		Long serveyId;
		public ServeyId(Long value) {
			this.serveyId = value;
		}
	}

	@Value
	public static class ServeyName {
		String nameValue;

		public ServeyName(String value) {
			this.nameValue = value;
		}
	}

	@Value
	public static class ServeyDescription {
		String descriptionValue;

		public ServeyDescription(String value) {
			this.descriptionValue = value;
		}
	}

	@Value
	public static class ServeyQuestion {
		List<Question> questionValue;

		public ServeyQuestion(List<Question> value) {
			this.questionValue = value;
		}
	}
}
