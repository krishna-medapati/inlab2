package com.klef.fsad.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.time.LocalDate;
import java.util.Scanner;

@SpringBootApplication
public class ClientDemo {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(ClientDemo.class, args);
        EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
        EntityManager em = emf.createEntityManager();

        Scanner sc = new Scanner(System.in);

        System.out.println("===== SUPPLIER MENU =====");
        System.out.println("1. Insert Supplier");
        System.out.println("2. Update Supplier");
        System.out.print("Enter Your Choice: ");
        int choice = Integer.parseInt(sc.nextLine());

        if (choice == 1) {

            System.out.println("\n===== INSERT SUPPLIER =====");

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Status: ");
            String status = sc.nextLine();

            Supplier supplier = new Supplier();
            supplier.setName(name);
            supplier.setStatus(status);
            supplier.setDate(LocalDate.now());

            em.getTransaction().begin();
            em.persist(supplier);
            em.getTransaction().commit();

            System.out.println("Record Inserted Successfully");
            System.out.println("Auto Generated ID is " + supplier.getId());
            System.out.println("ID: " + supplier.getId() + " Name: " + supplier.getName() + " Status: " + supplier.getStatus());

        } else if (choice == 2) {

            System.out.println("\n===== UPDATE SUPPLIER =====");

            System.out.print("Enter ID to Update: ");
            int idToUpdate = Integer.parseInt(sc.nextLine());

            em.getTransaction().begin();
            Supplier existing = em.find(Supplier.class, idToUpdate);

            if (existing != null) {
                System.out.print("Enter New Name: ");
                String newName = sc.nextLine();

                System.out.print("Enter New Status: ");
                String newStatus = sc.nextLine();

                existing.setName(newName);
                existing.setStatus(newStatus);
                em.merge(existing);
                em.getTransaction().commit();

                System.out.println("Record Updated Successfully");
                System.out.println("ID: " + existing.getId() + " Name: " + existing.getName() + " Status: " + existing.getStatus());
            } else {
                System.out.println("No record found for ID " + idToUpdate);
            }

        } else {
            System.out.println("Invalid Choice");
        }

        em.close();
        sc.close();
    }
}
