package com.nithyan.taskmgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins={"http://localhost:8585"}, maxAge=4800, allowCredentials="false")
public class TaskmgmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskmgmtApplication.class, args);
	}
}
