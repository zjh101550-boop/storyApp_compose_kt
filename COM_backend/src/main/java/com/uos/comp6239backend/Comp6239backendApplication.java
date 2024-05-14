package com.uos.comp6239backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@MapperScan(basePackages = "com.uos.comp6239backend.**.mapper")
//@SpringBootApplication
@EnableSwagger2
public class Comp6239backendApplication {

	public static void main(String[] args) {
		SpringApplication.run(Comp6239backendApplication.class, args);
	}

}
