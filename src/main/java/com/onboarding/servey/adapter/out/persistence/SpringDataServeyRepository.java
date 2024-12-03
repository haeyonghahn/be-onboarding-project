package com.onboarding.servey.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataServeyRepository extends JpaRepository<ServeyEntity, Long> {
}
