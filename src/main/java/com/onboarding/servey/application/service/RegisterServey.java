package com.onboarding.servey.application.service;

import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;

import com.onboarding.common.annotation.UseCase;
import com.onboarding.servey.application.port.in.RegisterServeyCommand;
import com.onboarding.servey.application.port.in.RegisterServeyUseCase;
import com.onboarding.servey.application.port.out.RegisterServeyPort;
import com.onboarding.servey.domain.Servey;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
@Transactional
public class RegisterServey implements RegisterServeyUseCase {

	private final RegisterServeyPort registerServeyPort;
	private final ModelMapper modelMapper;

	@Override
	public void registerServey(RegisterServeyCommand command) {
		Servey servey = modelMapper.map(command, Servey.class);
		registerServeyPort.createServey(servey);
	}
}
