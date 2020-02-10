package com.ur.popbackend.controllers;

import com.ur.popbackend.beans.LeaveBean;
import com.ur.popbackend.beans.MemberBean;
import com.ur.popbackend.mappers.abstract_mappers.MemberMapperImpl;
import com.ur.popbackend.repositories.MemberRepository;
import com.ur.popbackend.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;



    @GetMapping("/")
    public Page<MemberBean> getMembers(Pageable p){
        return memberService.getMembers(p);
    }

    @GetMapping("/{id}/leaves")
    public Page<LeaveBean> getLeaves(Pageable p, @PathVariable int id){
        Page page = new PageImpl(memberService.leaveBeansMock.stream().filter(l-> l.getId() == id && l.getStatus().equals("Approved")).collect(Collectors.toList()));
        return page;
    }
}
