package com.onboarding.servey.adapter.out.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.onboarding.common.domain.BaseEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "servey")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ServeyEntity extends BaseEntity {

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String description;

	@JsonManagedReference
	@OneToMany(mappedBy = "servey", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<QuestionEntity> questions = new ArrayList<>();

	@Builder
	public ServeyEntity(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public void addQuestion(QuestionEntity question) {
		this.questions.add(question);
		question.setServeyEntity(this);
	}
}
