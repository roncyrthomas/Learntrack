package com.airtribe.learntrack.entity;

public class Student extends Person{

    private String batch;
    private boolean active;
    private String rollNumber;

    public Student(int id, String firstName, String lastName, String email, boolean active) {
        super(id, firstName, lastName, email);

        this.active = active;
    }

    public String getRollNumber() {
        return rollNumber;
    }
    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getBatch() {
        return batch;
    }
    public void setBatch(String batch) {
        this.batch = batch;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
}
