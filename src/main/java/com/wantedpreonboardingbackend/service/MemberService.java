package com.wantedpreonboardingbackend.service;

import com.wantedpreonboardingbackend.controller.dto.CommonResponse;
import com.wantedpreonboardingbackend.controller.dto.MemberCreateRequest;
import com.wantedpreonboardingbackend.domain.Member;
import com.wantedpreonboardingbackend.repository.MemberRepository;
import com.wantedpreonboardingbackend.util.StatusCode;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public CommonResponse createMember(MemberCreateRequest memberCreateRequest) {
        Member member = toMemberEntity(memberCreateRequest);
        memberRepository.save(member);
        return CommonResponse.builder()
                .code(StatusCode.SUCCESS.getCode())
                .message(StatusCode.SUCCESS.getMessage())
                .build();
    }

    public Member toMemberEntity(MemberCreateRequest memberCreateRequest) {
        return Member.builder()
                .username(memberCreateRequest.getUsername())
                .password(passwordEncoder.encode(memberCreateRequest.getPassword()))
                .email(memberCreateRequest.getEmail())
                .build();
    }
}
