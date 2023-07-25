package com.example.myProject06.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass //JPA가 해당클래스는 테이블로 생성하지 않음 (공통 매핑정보가 필요할때 사용)
@EntityListeners(
        value = {AuditingEntityListener.class} // 엔티티 변화 감지 기능.
)
@Getter
@Setter
@ToString
abstract class BaseEntity {

    @CreatedDate
    LocalDateTime regDate;

    @LastModifiedDate
    LocalDateTime modDate;
}
