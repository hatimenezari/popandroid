package com.ur.popbackend.repositories;

import com.ur.popbackend.entities.Member;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MemberRepository extends PagingAndSortingRepository<Member, Integer> {

}
