package com.sbp.java21features;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;


@SpringBootApplication
@Slf4j
public class Java21featuresApplication {

	public static void main(String[] args) {
		SpringApplication.run(Java21featuresApplication.class, args);

//		virtualThreadDemo();
		charracterCount("ArunDhwaja");
	}

	private static void virtualThreadDemo() {
		try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
			IntStream.range(0, 10_000).forEach(i -> {
				executor.submit(() -> {
					Thread.sleep(Duration.ofSeconds(1));
					System.out.println("New path: " + i);
					return i;
				});
			});
		}
	}
	
	//Zensar: L1: 7th Oct, 2023
	private static void charracterCount( String str) {

//		Character[] characters = str.toCharacterArray();

		HashMap<Character, Integer> charCount = new HashMap<>();

		for (Character ch : str.toCharArray()) {
			if (charCount.containsKey(ch))
				charCount.put(ch, charCount.get(ch) + 1);
			else {
				charCount.put(ch, 1);
			}
		}

		for (Character ch : charCount.keySet()) {
			log.info("key: " + ch + " , : " + charCount.get(ch));
		}
	}
}
