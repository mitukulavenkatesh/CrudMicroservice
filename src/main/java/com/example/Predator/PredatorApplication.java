package com.example.Predator;

import java.util.Map.Entry;
import java.util.*;
import java.util.stream.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.Predator.model.EmployeModel;

@SpringBootApplication
public class PredatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PredatorApplication.class, args);

		Map<String, List<String>> recipess = new HashMap<>();
		recipess.put("Pasta", Arrays.asList("Tomato", "Basil", "Salt"));
		recipess.put("Salad", Arrays.asList("Lettuce", "Tomato", "Olive Oil"));
		recipess.put("Omelette", Arrays.asList("Eggs", "Salt", "Butter"));

//		Venkey(recipess, Arrays.asList("Olive Oil"));

		List<EmployeModel> employees = Arrays.asList(new EmployeModel("Amit", 28, "Pune", 50000),
				new EmployeModel("Neha", 32, "Pune", 60000), new EmployeModel("Raj", 30, "Pune", 55000),
				new EmployeModel("Kiran", 40, "Pune", 70000), new EmployeModel("Sita", 27, "Mumbai", 65000));

		Optional<EmployeModel> secondHighest = employees.stream()
				.filter(e -> e.getAge() >= 25 && e.getAge() <= 40 && "Mumbai".equalsIgnoreCase(e.getCity()))
				.sorted(Comparator.comparingDouble(EmployeModel::getSalary)).findFirst();

//		System.out.println(secondHighest);

		String str = "aaabbbcccdddeeeffffaabbccddeefff";

		
		Map<Character, Long> counts = str.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));

		Map<Character, Integer> names = new HashMap<>();
		for (char ch : str.toCharArray()) {
			names.put(ch, names.getOrDefault(ch, 0) + 1);
		}
		List<String> data = new ArrayList<>();
		names.forEach((ch, cou) -> {
			data.add(ch + " = " + cou);

		});
//		System.out.println(data);

		System.out.println(isAnagram("abc", "bca")); // true
		//System.out.println(isAnagram("aabc", "abc")); // false
	}

	public static boolean isAnagram(String s1, String s2) {

		if (s1.length() != s2.length())
			return false;
System.out.println("hitting");
		char[] name1 = s1.toCharArray();
		char[] name2 = s2.toCharArray();
		Arrays.sort(name1);
		Arrays.sort(name2);
		return Arrays.equals(name1, name2);

	}

	public static List<String> Venkey(Map<String, List<String>> recipess, List<String> dish) {
		List<String> data = new ArrayList<>();
		for (Map.Entry<String, List<String>> entry : recipess.entrySet()) {
			for (String more : dish) {
				if (entry.getValue().contains(more)) {
					data.add(entry.getKey());
				}
			}
		}

		return data;
	}

}
