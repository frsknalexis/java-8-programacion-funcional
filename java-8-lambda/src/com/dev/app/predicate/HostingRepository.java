package com.dev.app.predicate;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class HostingRepository {

	public static <T> List<T> filterHosting(List<T> list, Predicate<T> predicate) {
		return list.stream()
				.filter(predicate::test)
				.collect(Collectors.toList());
	}
}
