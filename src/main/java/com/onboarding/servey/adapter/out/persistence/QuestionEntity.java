package com.onboarding.servey.adapter.out.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.onboarding.common.domain.BaseEntity;
import com.onboarding.servey.domain.QuestionType;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "question")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class QuestionEntity extends BaseEntity {

	@Column(nullable = false)
	private String name;

	private String description;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private QuestionType type;

	@Column(nullable = false)
	private boolean required;

	private String answer;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "servey_id")
	private ServeyEntity servey;

	@JsonManagedReference
	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OptionEntity> options = new ArrayList<>();

	@Builder
	public QuestionEntity(String name, String description, QuestionType type, boolean required, String answer) {
		this.name = name;
		this.description = description;
		this.type = type;
		this.required = required;
		this.answer = answer;
	}

	public void setServeyEntity(ServeyEntity servey) {
		this.servey = servey;
	}

	public void addOption(OptionEntity option) {
		this.options.add(option);
		option.setQuestion(this);
	}
}
