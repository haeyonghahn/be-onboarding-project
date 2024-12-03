package com.onboarding.servey.application.port.in;

import com.onboarding.servey.domain.Servey;

public interface FindServeyUseCase {

	Servey findServey(FindServeyCommand findServeyCommand);
}
