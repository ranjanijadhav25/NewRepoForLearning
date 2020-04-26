package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired
	CustomerRepository customerRepository;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		customerRepository.deleteAll();
		
		customerRepository.save(new Customer("1","Alice", "Smith"));
		customerRepository.save(new Customer("2","Bob", "Smith"));
		
	    System.out.println("Customers found with findAll():");
	    System.out.println("-------------------------------");
	    
	    for(Customer cust:customerRepository.findAll()) {
	    	System.out.println(cust);
	    }
	    
	    System.out.println("Customer found with findByFirstName('Alice'):");
	    System.out.println("--------------------------------");
	    System.out.println(customerRepository.findByFirstName("Alice"));


	    System.out.println("Customers found with findByLastName('Smith'):");
	    System.out.println("--------------------------------");

	    for(Customer cust: customerRepository.findByLastName("Smith")) {
	    	System.out.println(cust);
	    }
	}

}
