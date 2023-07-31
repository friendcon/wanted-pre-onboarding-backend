package com.wantedpreonboardingbackend.controller;

import com.wantedpreonboardingbackend.controller.dto.CommonResponse;
import com.wantedpreonboardingbackend.controller.dto.MemberCreateRequest;
import com.wantedpreonboardingbackend.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<CommonResponse> createMember(@Valid @RequestBody MemberCreateRequest memberCreateRequest) {
        CommonResponse response = memberService.createMember(memberCreateRequest);
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
