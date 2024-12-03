package com.onboarding.servey.application.port.out;

import com.onboarding.servey.domain.Servey;

public interface FindServeyPort {

	Servey findServey(Long serveyId);
}
