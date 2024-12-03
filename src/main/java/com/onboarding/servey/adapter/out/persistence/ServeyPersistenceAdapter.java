package com.onboarding.servey.adapter.out.persistence;

import com.onboarding.common.annotation.PersistenceAdapter;
import com.onboarding.common.exception.BaseException;
import com.onboarding.servey.application.port.out.FindServeyPort;
import com.onboarding.servey.application.port.out.RegisterServeyPort;
import com.onboarding.servey.domain.Servey;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class ServeyPersistenceAdapter implements FindServeyPort, RegisterServeyPort {

	private final SpringDataServeyRepository serveyRepository;
	private final ServeyMapper serveyMapper;

	@Override
	public Servey findServey(Long serveyId) {
		ServeyEntity serveyEntity = serveyRepository.findById(serveyId)
			.orElseThrow(() -> new BaseException("등록된 설문조사가 없습니다."));
		return serveyMapper.mapToDomainEntity(serveyEntity);
	}

	@Override
	public void createServey(Servey servey) {
		serveyRepository.save(serveyMapper.mapToJpaEntity(servey));
	}
}
