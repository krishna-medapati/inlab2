package com.klef.fsad.exam;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "supplier")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private int id;

    @Column(name = "supplier_name")
    private String name;

    @Column(name = "supplier_description")
    private String description;

    @Column(name = "supplier_date")
    private LocalDate date;

    @Column(name = "supplier_status")
    private String status;

    @Column(name = "supplier_email")
    private String email;

    @Column(name = "supplier_contact")
    private String contact;

    public Supplier() {}

    public Supplier(String name, String description, LocalDate date,
                    String status, String email, String contact) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.status = status;
        this.email = email;
        this.contact = contact;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }

    public String toString() {
        return "ID: " + id + " Name: " + name + " Status: " + status;
    }
}