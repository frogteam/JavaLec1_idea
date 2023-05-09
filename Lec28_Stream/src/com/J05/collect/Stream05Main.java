package com.J05.collect;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Stream05Main {
	public static void main(String[] args) {

		new DefaultRunnder().run("aaa", "bbb", "ccc");
		
	}
} // end class

class DefaultRunnder{
	public void run(String...args) {
		System.out.println(
				Arrays.asList(args)
					.stream()
					.collect(Collectors.joining(",", getClass().getSimpleName() + "[", "]"))
								  	// joining(delimeter, prefix, suffix)
				);
	}
}
