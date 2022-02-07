package com.synechron;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;

class SampleReactiveTest {

	@Test
	void test() {
		assertTrue(true);
	}
	
	@Test
	void pushVsPullTest() {
		List<String> langs = Arrays.asList("Java", "JS", "Ruby", "Go", "Python");
		
		//PULL MODEL
		Iterator<String> langsItr = langs.iterator();
		while(langsItr.hasNext()) {
			String lang = langsItr.next();
			System.out.println(lang);
		}
		langs.stream().forEach(System.out::println);
		

		//PUSH MODEL (REACTIVE STYLE)
		Flux<String> source = Flux.fromIterable(langs);
		source.subscribe(System.out::println);
		source.subscribe(lang -> System.out.println(lang.toLowerCase()));
		
	}

}
