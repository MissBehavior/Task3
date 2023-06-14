package com.example.task3;

import com.example.task3.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
class LoadDatabase {


    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(/*EmployeeRepository employeeRepository,*/ OrderRepository orderRepository) {

        return args -> {
//            log.info("Preloading " + employeeRepository.save(new Employee("Bilbo Baggins", "burglar", "Chief")));
//            log.info("Preloading " + employeeRepository.save(new Employee("Frodo Baggins", "thief", "Worker")));
//            employeeRepository.findAll().forEach(employee -> log.info("Preloaded " + employee));
//

            Category category = new Category("PhoneCase");
            Category category1 = new Category("Gadget");
            Product product = new Product("Black Leather Phone Case", 15, category);
            Product product1 = new Product("White Plastic Case", 10, category);
            Product product2 = new Product("Selfie Stick", 22, category1);
            OrderItem orderItem = new OrderItem(product,2);
            OrderItem orderItem1 = new OrderItem(product1, 1);
            OrderItem orderItem2 = new OrderItem(product2, 3);
            User user = new User("Bob", "123", "bob@gmail.com", false);
            User user2 = new User("Hans", "1234", "hans@gmail.com", false);
            Courier courier = new Courier("John", "Smith", "867530589");
            Courier courier2 = new Courier("Peter", "Decker", "123456677");
            Order order = new Order(user, courier,"Jasinskio g. 15", List.of(orderItem, orderItem1),Status.COMPLETED );
            Order order2 = new Order(user2, courier2,"Jasinskio g. 71", List.of(orderItem2),Status.IN_PROGRESS);

            orderRepository.save(order);
            orderRepository.save(order2);


            orderRepository.findAll().forEach(orderElement -> {
                log.info("Preloaded " + orderElement);
            });

        };
    }
}