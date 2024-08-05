package be.digitcom.streams;

import be.digitcom.streams.models.Employee;
import org.junit.jupiter.api.Test;


import java.util.Arrays;


class StreamsGuideApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void whenIncrementSalaryForEachEmployee_thenApplyNewSalary() {
		Arrays
				.stream(employees)
				.forEach(employee -> employee.salaryIncrement(10.0));

		//Assertions.assertTrue(Arrays.stream(employees).toList().contains());
	}

	private Employee[] employees = {
			new Employee(1, "Jeff Bezos", 100000.0),
			new Employee(2, "Bill Gates", 200000.0),
			new Employee(3, "Mark Zuckerberg", 300000.0),
	};

}
