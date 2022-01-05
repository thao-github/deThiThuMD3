package model;

import java.sql.Date;

public class Student {
    private int id;
    private String name;
    private Date dateOfBirth;
    private String address;
    private String phoneNumber;
    private String email;
    private String className;

    private int idClassroom;

    public Student(int id, String name, Date dateOfBirth, String address, String phoneNumber, String email, int idClassroom) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.idClassroom = idClassroom;
    }



    public Student(String name, Date dateOfBirth, String address, String phoneNumber, String email, int idClassroom) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.idClassroom = idClassroom;
    }

    public Student(int id, String name, Date dateOfBirth, String address, String phoneNumber, String email, String className, int idClassroom) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.className = className;
        this.idClassroom = idClassroom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdClassroom() {
        return idClassroom;
    }

    public void setIdClassroom(int idClassroom) {
        this.idClassroom = idClassroom;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
