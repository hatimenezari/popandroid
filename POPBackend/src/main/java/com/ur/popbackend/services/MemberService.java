package com.ur.popbackend.services;

import com.ur.popbackend.beans.MemberBean;
import com.ur.popbackend.entities.Member;
import com.ur.popbackend.mappers.abstract_mappers.MemberMapperImpl;
import com.ur.popbackend.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public Page<MemberBean> getMembers(Pageable p){
        Page<Member> members = memberRepository.findAll(p);

        return  members.map(m -> new MemberMapperImpl().memberToMemberBean(m));
    }

}
