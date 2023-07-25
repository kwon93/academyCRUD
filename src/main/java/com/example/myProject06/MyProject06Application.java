package com.example.myProject06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // 이게 있어야  엔티티속에 jpa 애노테이션 인식함.
@SpringBootApplication
public class MyProject06Application {

	public static void main(String[] args) {
		SpringApplication.run(MyProject06Application.class, args);
	}

}
