package com.icss.da2.pojo;


import java.util.Objects;

public class Employee {
    private String username;
    private String password;

    public Employee() {
    }

    public Employee(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(username, employee.username) &&
                Objects.equals(password, employee.password);
    }

    @Override
    public int hashCode() {

        return Objects.hash(username, password);
    }
}
