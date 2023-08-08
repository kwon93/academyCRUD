package com.example.myProject06.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDTO {

    private String id;
    private String password;
    private String name;
    private LocalDateTime regDate;
    private LocalDateTime modDate;

}
