package com.onboarding.servey.adapter.out.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.onboarding.common.domain.BaseEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "option")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OptionEntity extends BaseEntity {

	@Column(nullable = false)
	private int number;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "question_id")
	private QuestionEntity question;

	@Builder
	public OptionEntity(int number, QuestionEntity question) {
		this.number = number;
		this.question = question;
	}

	public void setQuestion(QuestionEntity question) {
		this.question = question;
	}
}
