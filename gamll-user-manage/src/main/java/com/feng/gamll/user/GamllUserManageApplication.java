package com.feng.gamll.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.feng.gamll.user.mapper")
public class GamllUserManageApplication {

	public static void main(String[] args) {
		SpringApplication.run(GamllUserManageApplication.class, args);
	}

}
