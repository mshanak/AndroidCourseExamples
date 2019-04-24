package com.mshanak.adroidcourseexamples;

public class Person {
    int id;
    String Name;
    String LastName;
    String Qualifications;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getQualifications() {
        return Qualifications;
    }

    public void setQualifications(String qualifications) {
        Qualifications = qualifications;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Qualifications='" + Qualifications + '\'' +
                '}';
    }
}
