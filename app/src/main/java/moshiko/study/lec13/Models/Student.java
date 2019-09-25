package moshiko.study.lec13.Models;

public class Student {
    public String name;
    public String email;
    int id;

    public Student(String name, String email, int id) {
        this.name = name;
        this.email = email;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", id=" + id +
                '}';
    }
}
