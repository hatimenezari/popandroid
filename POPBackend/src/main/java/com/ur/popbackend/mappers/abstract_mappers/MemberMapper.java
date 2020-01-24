package com.ur.popbackend.mappers.abstract_mappers;

import com.ur.popbackend.beans.MemberBean;
import com.ur.popbackend.entities.Member;
import org.mapstruct.Mapper;

@Mapper
public interface MemberMapper {

    Member memberBeanToMember(MemberBean memberBean);
    MemberBean memberToMemberBean(Member member);
}
