package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.dao"})
public class SpringbootSchemaApplication {

	//http://localhost:8081/springbootjlvpC/front/index.html
	public static void main(String[] args) {
		SpringApplication.run(SpringbootSchemaApplication.class, args);
	}

}
