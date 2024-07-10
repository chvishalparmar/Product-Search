package com.training.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Addfiles {
	public List<Path> addfiles() throws IOException {
		String temp = System.getProperty("user.dir") + "/src/main/java/resources";

		Path path = Paths.get(temp);
		List<Path> paths = listFiles(path);
		// paths.forEach(x -> System.out.println(x));

		return paths;

	}

	public static List<Path> listFiles(Path path) throws IOException {

		List<Path> result;
		try (Stream<Path> walk = Files.walk(path)) {
			result = walk.filter(Files::isRegularFile).collect(Collectors.toList());
		}
		return result;

	}

}
