package com.onboarding.servey.application.service;

import org.springframework.transaction.annotation.Transactional;

import com.onboarding.common.annotation.UseCase;
import com.onboarding.servey.application.port.in.FindServeyCommand;
import com.onboarding.servey.application.port.in.FindServeyUseCase;
import com.onboarding.servey.application.port.out.FindServeyPort;
import com.onboarding.servey.domain.Servey;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
@Transactional
public class FindServey implements FindServeyUseCase {

	private final FindServeyPort findServeyPort;

	@Override
	public Servey findServey(FindServeyCommand command) {
		return findServeyPort.findServey(command.getServeyId());
	}
}
