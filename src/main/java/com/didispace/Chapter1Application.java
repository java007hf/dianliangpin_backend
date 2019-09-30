package com.didispace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Chapter1Application extends SpringBootServletInitializer implements CommandLineRunner {
	@Autowired
	DataSourceProperties dataSourceProperties;

	@Autowired
	ApplicationContext applicationContext;

	public static void main(String[] args) {

		SpringApplication.run(Chapter1Application.class, args);
	}


	@Override
	public void run (String... strings) throws Exception {
//		// 获取配置的数据源
//		DataSource dataSource = applicationContext.getBean(DataSource.class);
//		// 查看配置数据源信息
//		System.out.println(dataSource);
//		System.out.println(dataSource.getClass().getName());
//		System.out.println(dataSourceProperties);
	}
}
