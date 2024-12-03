package com.onboarding.servey.application.port.in;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.onboarding.common.annotation.SelfValidating;
import com.onboarding.common.validation.Type;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class RegisterQuestionCommand extends SelfValidating<RegisterQuestionCommand> {

	@NotEmpty(message = "설문 받을 항목 이름이 입력되지 않았습니다.")
	private String name;
	private String description;
	@Type
	private String type;
	private boolean required;
	private List<RegisterOptionCommand> options;

	public RegisterQuestionCommand(String name, String description, String type, boolean required,
		List<RegisterOptionCommand> options) {
		this.name = name;
		this.description = description;
		this.type = type;
		this.required = required;
		this.options = options;
	}
}
