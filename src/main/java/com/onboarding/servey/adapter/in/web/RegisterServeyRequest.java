package com.onboarding.servey.adapter.in.web;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@ApiModel(description = "설문조사 요청")
@Getter
@NoArgsConstructor
public class RegisterServeyRequest {

	@ApiModelProperty(notes = "설문조사 이름", example = "INNER CIRCLE 풀스택 개발 코스 사전 조사", required = true, dataType = "string")
	private String name;

	@ApiModelProperty(notes = "설문조사 설명", example = "안녕하세요? 패스트캠퍼스입니다.", required = true, dataType = "string")
	private String description;

	private List<RegisterQuestionRequest> questions;
}
