package com.onboarding.servey.adapter.out.persistence;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.onboarding.servey.domain.Option;
import com.onboarding.servey.domain.Question;
import com.onboarding.servey.domain.Servey;

@Component
public class ServeyMapper {

	Servey mapToDomainEntity(ServeyEntity servey) {
		return Servey.generateServey(
			new Servey.ServeyId(servey.getId()),
			new Servey.ServeyName(servey.getName()),
			new Servey.ServeyDescription(servey.getDescription()),
			new Servey.ServeyQuestion(servey.getQuestions().stream()
				.map(this::mapToDomainEntity)
				.collect(Collectors.toList()))
		);
	}

	ServeyEntity mapToJpaEntity(Servey servey) {
		return ServeyEntity.builder()
			.name(servey.getName())
			.description(servey.getDescription())
			.build();
	}

	Question mapToDomainEntity(QuestionEntity question) {
		return Question.generateQuestion(
			new Question.QuestionId(question.getId()),
			new Question.QuestionName(question.getName()),
			new Question.QuestionDescription(question.getDescription()),
			new Question.QuestionType(question.getType().name()),
			new Question.QuestionRequired(question.isRequired()),
			new Question.QuestionAnswer(question.getAnswer()),
			new Question.QuestionOption(question.getOptions().stream()
				.map(this::mapToDomainEntity)
				.collect(Collectors.toList()))
		);
	}

	Option mapToDomainEntity(OptionEntity option) {
		return Option.generateOption(
			new Option.OptionId(option.getId()),
			new Option.OptionNumber(option.getNumber())
		);
	}
}
