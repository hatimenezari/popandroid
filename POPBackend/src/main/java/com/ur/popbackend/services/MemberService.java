package com.ur.popbackend.services;

import com.ur.popbackend.beans.LeaveBean;
import com.ur.popbackend.beans.MemberBean;
import com.ur.popbackend.entities.Member;
import com.ur.popbackend.mappers.abstract_mappers.MemberMapperImpl;
import com.ur.popbackend.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<LeaveBean> leaveBeansMock = new ArrayList();

    @PostConstruct
    public void init()
    {
        leaveBeansMock.add(new LeaveBean(
                        1,
                        LocalDate.now(),
                        LocalDate.of(2020, Month.JANUARY, 30),
                        LocalDate.of(2020, Month.FEBRUARY, 10),
                        12,
                        "Pending",
                        "caught a cold",
                        new MemberMapperImpl().memberToMemberBean(memberRepository.findById(1).get()),
                        "Sick"
                )
        );
        leaveBeansMock.add(new LeaveBean(
                        2,
                        LocalDate.now(),
                        LocalDate.of(2019, Month.DECEMBER, 25),
                        LocalDate.of(2019, Month.DECEMBER, 28),
                        4,
                        "Pending",
                        "headach",
                        new MemberMapperImpl().memberToMemberBean(memberRepository.findById(2).get()),
                        "Sick"
                )
        );
        leaveBeansMock.add(new LeaveBean(
                        3,
                        LocalDate.now(),
                        LocalDate.of(2020, Month.JANUARY, 30),
                        LocalDate.of(2020, Month.FEBRUARY, 10),
                        12,
                        "Denied",
                        "gotta play the new cyberpunk",
                        new MemberMapperImpl().memberToMemberBean(memberRepository.findById(1).get()),
                        "Vacation"
                )
        );
        leaveBeansMock.add(new LeaveBean(
                        4,
                        LocalDate.now(),
                        LocalDate.of(2020, Month.JANUARY, 30),
                        LocalDate.of(2020, Month.FEBRUARY, 10),
                        12,
                        "Approved",
                        "gotta play the new cyberpunk",
                        new MemberMapperImpl().memberToMemberBean(memberRepository.findById(1).get()),
                        "Vacation"
                )
        );
        leaveBeansMock.add(new LeaveBean(
                        1,
                        LocalDate.now(),
                        LocalDate.of(2020, Month.FEBRUARY, 19),
                        LocalDate.of(2020, Month.FEBRUARY, 20),
                        2,
                        "Approved",
                        "gotta play the new cyberpunk",
                        new MemberMapperImpl().memberToMemberBean(memberRepository.findById(1).get()),
                        "Vacation"
                )
        );
        leaveBeansMock.add(new LeaveBean(
                        1,
                        LocalDate.now(),
                        LocalDate.of(2020, Month.FEBRUARY, 26),
                        LocalDate.of(2020, Month.FEBRUARY, 28),
                        3,
                        "Approved",
                        "the spanish inquisition",
                        new MemberMapperImpl().memberToMemberBean(memberRepository.findById(1).get()),
                        "Vacation"
                )
        );

        leaveBeansMock.add(new LeaveBean(
                        1,
                        LocalDate.now(),
                        LocalDate.of(2020, Month.FEBRUARY, 10),
                        LocalDate.of(2020, Month.FEBRUARY, 15),
                        6,
                        "Approved",
                        "please?",
                        new MemberMapperImpl().memberToMemberBean(memberRepository.findById(1).get()),
                        "Sick"
                )
        );
    }

    public Page<MemberBean> getMembers(Pageable p){
        Page<Member> members = memberRepository.findAll(p);

        return  members.map(m -> new MemberMapperImpl().memberToMemberBean(m));
    }

}
