package com.onboarding.servey.adapter.in.web;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@ApiModel(description = "선택할 수 있는 후보")
@Getter
@NoArgsConstructor
public class RegisterOptionRequest {

	@ApiModelProperty(notes = "번호", example = "1", required = true, dataType = "int")
	private Integer number;
}
