package com.onboarding.servey.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {

	private Long questionId;
	private String name;
	private String description;
	private String type;
	private boolean required;
	private String answer;
	private List<Option> options;

	public static Question generateQuestion(
		QuestionId questionId,
		QuestionName questionName,
		QuestionDescription questionDescription,
		QuestionType questionType,
		QuestionRequired questionRequired,
		QuestionAnswer questionAnswer,
		QuestionOption questionOption) {
		return new Question(
			questionId.questionId,
			questionName.nameValue,
			questionDescription.descriptionValue,
			questionType.typeValue,
			questionRequired.requiredValue,
			questionAnswer.answerValue,
			questionOption.optionValue);
	}

	@Value
	public static class QuestionId {
		Long questionId;

		public QuestionId(Long questionId) {
			this.questionId = questionId;
		}
	}

	@Value
	public static class QuestionName {
		String nameValue;

		public QuestionName(String value) {
			this.nameValue = value;
		}
	}

	@Value
	public static class QuestionDescription {
		String descriptionValue;

		public QuestionDescription(String value) {
			this.descriptionValue = value;
		}
	}

	@Value
	public static class QuestionType {
		String typeValue;

		public QuestionType(String value) {
			this.typeValue = value;
		}
	}

	@Value
	public static class QuestionRequired {
		boolean requiredValue;

		public QuestionRequired(boolean value) {
			this.requiredValue = value;
		}
	}

	@Value
	public static class QuestionAnswer {
		String answerValue;

		public QuestionAnswer(String value) {
			this.answerValue = value;
		}
	}

	@Value
	public static class QuestionOption {
		List<Option> optionValue;

		public QuestionOption(List<Option> value) {
			this.optionValue = value;
		}
	}
}
