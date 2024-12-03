package com.onboarding.servey.application.port.in;

import com.onboarding.common.annotation.SelfValidating;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class RegisterOptionCommand extends SelfValidating<RegisterOptionCommand> {

	private Integer number;

	public RegisterOptionCommand(Integer number) {
		this.number = number;
	}
}
