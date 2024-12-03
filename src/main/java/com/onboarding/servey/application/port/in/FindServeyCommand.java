package com.onboarding.servey.application.port.in;

import javax.validation.constraints.NotNull;

import com.onboarding.common.annotation.SelfValidating;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class FindServeyCommand extends SelfValidating<FindServeyCommand> {

	@NotNull
	private final Long serveyId;

	public FindServeyCommand(Long serveyId) {
		this.serveyId = serveyId;
	}
}
