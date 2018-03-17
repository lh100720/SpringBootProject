package com.li;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@RestController
@EnableWebSecurity
@EnableSwagger2
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	//有这样注解的表示只能被ADMIN访问，普通user不能访问
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping("/authorize")
	public String authorize() {
		return "有权限访问";
	}

	/*@RequestMapping("/security")
	public String security() {
		return "hello world security";
	}

	@RequestMapping("/springboot2")
	public String hello() {
		return "不需要验证哦";
	}*/
}
