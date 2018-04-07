package edu.zufe.rms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ResttMgmtSysApplication {
	private static final Logger log = LoggerFactory.getLogger(ResttMgmtSysApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ResttMgmtSysApplication.class, args);

	} 

}
