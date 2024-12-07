package com.onboarding.servey.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.onboarding.common.domain.BaseEntity;
import com.onboarding.servey.dto.request.ServeyRequest;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "servey")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Servey extends BaseEntity {

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String description;

	@JsonManagedReference
	@OneToMany(mappedBy = "servey", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Question> questions = new ArrayList<>();

	@Builder
	public Servey(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public void addQuestion(Question question) {
		this.questions.add(question);
		question.setServey(this);
	}

	public static Servey of(ServeyRequest serveyRequest) {
		return Servey.builder()
			.name(serveyRequest.getName())
			.description(serveyRequest.getDescription())
			.build();
	}

	public ServeyEditor.ServeyEditorBuilder toEditor() {
		return ServeyEditor.builder()
			.name(name)
			.description(description);
	}

	public void edit(ServeyEditor serveyEditor) {
		name = serveyEditor.getName();
		description = serveyEditor.getDescription();
	}
}
