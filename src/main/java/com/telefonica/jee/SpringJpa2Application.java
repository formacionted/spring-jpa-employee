package com.telefonica.jee;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.telefonica.jee.model.Employee;
import com.telefonica.jee.repository.EmployeeRepository;

@SpringBootApplication
public class SpringJpa2Application implements CommandLineRunner {

	// Objeto logger que nos permite imprimir en un log con mas informacion de lo
	// que haria un system.out.print
	private static final Logger log = LoggerFactory.getLogger(SpringJpa2Application.class);
	
	@Autowired
	private EmployeeRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJpa2Application.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

		log.info("Employees en base de datos: {}", repository.count());
		Employee employee1 = new Employee("Rigatuso", "Formentera");
		Employee employee2 = new Employee("Raul", "Atena");
		Employee employee3 = new Employee("Maturana", "Raeli");
		Employee employee4 = new Employee("Rosetti", "Massachussets");
		List<Employee> employees = Arrays.asList(new Employee[] {employee1, employee2, employee3, employee4});
		repository.saveAll(employees);
		log.info("Employees en base de datos: {}", repository.count());
		
		repository.save(new Employee("Rocatagliata", "para los amigos"));
		repository.save(new Employee("Arnaldo", "Suarez"));
		repository.save(new Employee("Osvaldo", "Atena"));
		repository.save(new Employee("Osvaldo", "Lirio"));
		repository.save(new Employee("Osvaldo", "El grande"));
		
		log.info("Employees en base de datos: {}", repository.count());
		
		log.info("Employees que se apellidan Atena: {}", repository.findByLastName("Atena").size());
		
		List<String> names = Arrays.asList(new String[] {"Osvaldo", "Arnaldo"});

		log.info("Osvaldo y Arnaldo: {}", repository.findByNameList(names).size());
		log.info("Osvaldo y Arnaldo: {}", repository.findByFirstNameIn(names).size());

		
		
	}

}
