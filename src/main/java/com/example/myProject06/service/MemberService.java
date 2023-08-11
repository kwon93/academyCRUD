package com.example.myProject06.service;


import com.example.myProject06.dto.MemberDTO;
import com.example.myProject06.entity.Member;
import org.springframework.data.domain.Page;

public interface MemberService {

    default MemberDTO entityToDTO(Member entity){
        MemberDTO dtoPage = MemberDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .password(entity.getPassword())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .role(entity.getRole())
                .build();
        return dtoPage;
    }

    Page<MemberDTO> getList(int pageNumber);


    boolean register(MemberDTO memberDTO);

    default Member memberDtoToEntity(MemberDTO memberDTO){
        return Member.builder()
                .id(memberDTO.getId())
                .name(memberDTO.getName())
                .password(memberDTO.getPassword())
                .role(memberDTO.getRole())
                .build();
    }

    MemberDTO read(String id);


}
