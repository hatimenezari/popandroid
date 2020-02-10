package com.ur.popbackend.controllers;

import com.ur.popbackend.beans.LeaveBean;
import com.ur.popbackend.entities.Member;
import com.ur.popbackend.mappers.abstract_mappers.MemberMapper;
import com.ur.popbackend.mappers.abstract_mappers.MemberMapperImpl;
import com.ur.popbackend.repositories.MemberRepository;
import com.ur.popbackend.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("leaves")
public class LeaveController {


    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberService memberService;

    @GetMapping("/")
    public Page<LeaveBean> getLeaves(){
        Page p = new PageImpl(memberService.leaveBeansMock);
        return p;
    }

    @PutMapping("/{id}")
    public void updateLeave(@PathVariable int id, @RequestBody LeaveBean leave){
        for(LeaveBean leaveBean: memberService.leaveBeansMock){
            if(leaveBean.getId() == id)
                leaveBean.setStatus(leave.getStatus());
        }
    }
}

