package com.example.myProject06.entity;

import lombok.*;
import org.checkerframework.checker.units.qual.C;
import org.checkerframework.checker.units.qual.N;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member extends BaseEntity{

    @Id
    @Column(length = 50)
    private String id;

    @Column(length = 200, nullable = false)
    private String password;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String role; //사용자 등급 추가

}
