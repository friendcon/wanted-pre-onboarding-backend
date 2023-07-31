package com.wantedpreonboardingbackend.controller.dto;

import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class MemberCreateRequest {
    String username;

    @Pattern(regexp = "^[A-Za-z0-9]{8,}$", message = "비밀번호를 8자 이상 입력하세요.")
    String password;

    @Pattern(regexp = ".*@.*", message = "이메일에 @가 포함되어야 합니다")
    String email;
}
