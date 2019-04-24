package oop.University;

public class Student extends Academic{

    private double stipend;

    public Student(Title title, int id, String name, double stipend){
        super(title, id, name);
        this.stipend = stipend;
    }

    public double getWeeklyPay() { return stipend; }

    public String toString() {
        int id = this.getID();
        String title = this.getTitle().toString();
        String str = "Student " + id + " studies a " + title;
        return str;
    }

}
