package com.ur.popbackend.controllers;



import com.ur.popbackend.beans.MemberBean;
import com.ur.popbackend.enums.Availability;
import com.ur.popbackend.services.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;


import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private MemberService memberService;

    @Test
    public void getMembers() throws Exception {
        List<MemberBean> membersList = new ArrayList<>();
        MemberBean memberBean = new MemberBean();
        memberBean.setAvailability(Availability.AVAILABLE);
        memberBean.setId(1);
        memberBean.setName("hatim");
        memberBean.setCompanyAnniversary(LocalDate.now().toString());
        memberBean.setCompanyRole("engineer");
        memberBean.setPhone("0634563214");
        memberBean.setStartingDate(LocalDate.now().toString());
        memberBean.setTimeZone(TimeZone.getTimeZone("America/Denver"));
        membersList.add(memberBean);
        Page<MemberBean> members = new PageImpl<>(membersList);

        when(memberService.getMembers(ArgumentMatchers.any(Pageable.class))).thenReturn(members);


        mockMvc.perform(get("/members/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].id", is(1)))
                .andExpect( jsonPath("$.content[0].name", is("hatim")))
                .andExpect( jsonPath("$.content[0].companyAnniversary", is(LocalDate.now().toString())))
                .andExpect( jsonPath("$.content[0].companyRole", is("engineer")))
                .andExpect( jsonPath("$.content[0].phone", is("0634563214")))
                .andExpect( jsonPath("$.content[0].timeZone", is("America/Denver")));

    }
}