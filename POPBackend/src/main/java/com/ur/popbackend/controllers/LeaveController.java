package com.ur.popbackend.controllers;

import com.ur.popbackend.beans.LeaveBean;
import com.ur.popbackend.entities.Member;
import com.ur.popbackend.mappers.abstract_mappers.MemberMapper;
import com.ur.popbackend.mappers.abstract_mappers.MemberMapperImpl;
import com.ur.popbackend.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("leaves")
public class LeaveController {

    List<LeaveBean> leaveBeansMock = new ArrayList();

    @Autowired
    private MemberRepository memberRepository;

    @PostConstruct
    public void init()
    {
        leaveBeansMock.add(new LeaveBean(
                        1,
                        LocalDate.now(),
                        LocalDate.of(2020, Month.JANUARY, 30),
                        LocalDate.of(2020, Month.FEBRUARY, 10),
                        11,
                        "Pending",
                        "caught a cold",
                        new MemberMapperImpl().memberToMemberBean(memberRepository.findById(1).get())
                )
        );
        leaveBeansMock.add(new LeaveBean(
                        2,
                        LocalDate.now(),
                        LocalDate.of(2019, Month.DECEMBER, 25),
                        LocalDate.of(2019, Month.DECEMBER, 28),
                        3,
                        "Pending",
                        "headach",
                        new MemberMapperImpl().memberToMemberBean(memberRepository.findById(2).get())
                )
        );
        leaveBeansMock.add(new LeaveBean(
                        3,
                        LocalDate.now(),
                        LocalDate.of(2020, Month.JANUARY, 30),
                        LocalDate.of(2020, Month.FEBRUARY, 10),
                        11,
                        "Denied",
                        "gotta play the new cyberpunk",
                        new MemberMapperImpl().memberToMemberBean(memberRepository.findById(3).get())
                )
        );
        leaveBeansMock.add(new LeaveBean(
                        4,
                        LocalDate.now(),
                        LocalDate.of(2020, Month.JANUARY, 30),
                        LocalDate.of(2020, Month.FEBRUARY, 10),
                        11,
                        "Approved",
                        "gotta play the new cyberpunk",
                        new MemberMapperImpl().memberToMemberBean(memberRepository.findById(3).get())
                )
        );
    }


    @GetMapping("/")
    public Page<LeaveBean> getLeaves(){
        Page p = new PageImpl(leaveBeansMock);
        return p;
    }

}

