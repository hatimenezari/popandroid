package com.ur.popbackend.mappers.abstract_mappers;

import com.ur.popbackend.beans.MemberBean;
import com.ur.popbackend.entities.Member;
import com.ur.popbackend.enums.Availability;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.*;

class MemberMapperTest {

    private MemberMapper memberMapper = new MemberMapperImpl();
    @Test
    void memberToMemberBean() {

        Member member = new Member();
        member.setAvailability(Availability.AVAILABLE);
        member.setName("hatim");
        member.setCompanyAnniversary(LocalDate.now());
        member.setCompanyRole("engineer");
        member.setPhone("0634563214");
        member.setStartingDate(LocalDate.now());
        member.setTimeZone(TimeZone.getTimeZone("America/Denver"));

        MemberBean memberBean = new MemberBean();
        memberBean.setAvailability(Availability.AVAILABLE);
        memberBean.setName("hatim");
        memberBean.setCompanyAnniversary(LocalDate.now().toString());
        memberBean.setCompanyRole("engineer");
        memberBean.setPhone("0634563214");
        memberBean.setStartingDate(LocalDate.now().toString());
        memberBean.setTimeZone(TimeZone.getTimeZone("America/Denver"));

        MemberBean convertedMemberBean = memberMapper.memberToMemberBean(member);

        assertTrue(convertedMemberBean.getCompanyAnniversary().equals(memberBean.getCompanyAnniversary()));
        assertTrue(convertedMemberBean.getStartingDate().equals(memberBean.getStartingDate()));
        assertTrue(convertedMemberBean.getAvailability().equals(memberBean.getAvailability()));
        assertTrue(convertedMemberBean.getCompanyRole().equals(memberBean.getCompanyRole()));
        assertTrue(convertedMemberBean.getName().equals(memberBean.getName()));
        assertTrue(convertedMemberBean.getPhone().equals(memberBean.getPhone()));
        assertTrue(convertedMemberBean.getTimeZone().equals(memberBean.getTimeZone()));
    }
}