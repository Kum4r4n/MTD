package com.bcas.mtd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.TimeZone;

@SpringBootApplication
public class MtdApplication {

	public static void main(String[] args) {
		//TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		SpringApplication.run(MtdApplication.class, args);
	}

}
