package com.onboarding.servey.adapter.in.web;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onboarding.common.annotation.WebAdapter;
import com.onboarding.common.controller.ApiController;
import com.onboarding.servey.application.port.in.FindServeyCommand;
import com.onboarding.servey.application.port.in.FindServeyUseCase;
import com.onboarding.servey.application.port.in.RegisterServeyCommand;
import com.onboarding.servey.application.port.in.RegisterServeyUseCase;
import com.onboarding.servey.domain.Servey;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Api("설문조사 API")
@Slf4j
@WebAdapter
@RequestMapping("/api/v1/servey")
@RequiredArgsConstructor
public class ServeyController extends ApiController {

	private final FindServeyUseCase findServeyUseCase;
	private final RegisterServeyUseCase registerServeyUseCase;
	private final ModelMapper modelMapper;

	@ApiOperation(value = "설문조사 응답 조회", notes = "설문조사 응답을 조회합니다.")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "serveyId", value = "설문조사 ID", required = true, dataType = "long", paramType = "path")
	})
	@GetMapping(value = "/{serveyId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Servey> survey(@PathVariable Long serveyId) {
		FindServeyCommand command = FindServeyCommand.builder()
			.serveyId(serveyId)
			.build();
		return ResponseEntity.ok(findServeyUseCase.findServey(command));
	}

	@ApiOperation(value = "설문조사 생성", notes = "설문조사를 생성합니다.")
	@PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> registerServey(@Valid @RequestBody RegisterServeyRequest request) {
		RegisterServeyCommand command = modelMapper.map(request, RegisterServeyCommand.class);
		registerServeyUseCase.registerServey(command);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
