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
                .build();
        return dtoPage;
    }

    Page<MemberDTO> getList(int pageNumber);

}
