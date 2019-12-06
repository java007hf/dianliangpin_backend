package com.didispace;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EnableScheduling
@EnableAsync
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread ().getId () + "main begin");
		SpringApplication.run(Application.class, args);
		System.out.println(Thread.currentThread ().getId () + "main end");
	}

	@Bean
	public AsyncLoader dataLoader() {
		Exception e = new Exception("this is a log");
		e.printStackTrace();
		return new AsyncLoader();
	}

	@Slf4j
	static class AsyncLoader implements CommandLineRunner {
		@Autowired
		private AsyncTask task;
		private void testAsyncTask() throws Exception {
			task.doTaskOne();
			task.doTaskTwo();
			task.doTaskThree();
		}

		@Override
		public void run(String... strings) throws Exception {
			log.info("Loading data...");
			try {
				testAsyncTask();
			} catch (Exception e) {
				e.printStackTrace ();
			}
		}
	}
}
