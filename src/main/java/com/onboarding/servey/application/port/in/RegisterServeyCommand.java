package com.onboarding.servey.application.port.in;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.onboarding.common.annotation.SelfValidating;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class RegisterServeyCommand extends SelfValidating<RegisterServeyCommand> {

	@NotEmpty(message = "설문조사 이름이 입력되지 않았습니다.")
	private String name;

	@NotEmpty(message = "설문조사 설명이 입력되지 않았습니다.")
	private String description;

	@Size(min = 1, max = 10, message = "설문 받을 항목은 1개 ~ 10개까지 포함 할 수 있습니다.")
	private List<RegisterQuestionCommand> questions;

	public RegisterServeyCommand(String name, String description, List<RegisterQuestionCommand> questions) {
		this.name = name;
		this.description = description;
		this.questions = questions;
	}
}
