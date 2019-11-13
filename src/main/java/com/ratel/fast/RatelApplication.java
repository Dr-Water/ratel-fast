

package com.ratel.fast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class RatelApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatelApplication.class, args);
		System.out.println("项目启动成功");
	}

}