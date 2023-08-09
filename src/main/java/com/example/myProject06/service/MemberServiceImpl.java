package com.example.myProject06.service;

import com.example.myProject06.dto.MemberDTO;
import com.example.myProject06.entity.Member;
import com.example.myProject06.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;


    @Override
    public Page<MemberDTO> getList(int page) {
        int pageNum = (page == 0)? 0 : page - 1;
        PageRequest pageable = PageRequest.of(pageNum, 10, Sort.by("regDate").descending());
        //생성된 날짜 별로 멤버들을 리스트함.
        Page<Member> entityPage = memberRepository.findAll(pageable);
        return entityPage.map(entity -> entityToDTO(entity));
    }

    @Override
    public boolean register(MemberDTO memberDTO) {
        String getId = memberDTO.getId();
        MemberDTO getDto = read(getId);
        if (getDto != null){
            System.out.println("사용중인 아이디 입니다.");
            return false;
        }
        Member entity = memberDtoToEntity(memberDTO);
        memberRepository.save(entity);
        return true;
    }

    @Override
    public MemberDTO read(String id) {
        Optional<Member> result = memberRepository.findById(id);
        if (result.isPresent()){
            Member member = result.get();
            return entityToDTO(member);
        }else {
            return null;
        }
    }



}
