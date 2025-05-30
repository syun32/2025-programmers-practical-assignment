package com.example.project2.domain;

import jakarta.validation.constraints.NotEmpty;

public class Customer implements Comparable<Customer> {
    private int id;
    @NotEmpty
    private String customer_name;
    private String check_in;
    private String check_out;
    private String status;

    public Customer() {}

    @Override
    public int compareTo(Customer customer) {
        return this.check_in.compareTo(customer.check_in);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCheck_in() {
        return check_in;
    }

    public void setCheck_in(String check_in) {
        this.check_in = check_in;
    }

    public String getCheck_out() {
        return check_out;
    }

    public void setCheck_out(String check_out) {
        this.check_out = check_out;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
