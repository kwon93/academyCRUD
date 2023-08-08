package com.example.myProject06.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder //객체를 생성하는 메서드 추가, 생성자와 달리 필요한값만 입력할 수 있음
public class Board extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_no")
    private int no;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 1500, nullable = false)
    private String content;

//    @Column(length = 50, nullable = false)
//    private String writer;
    
    @ManyToOne
    private Member writer;
}
