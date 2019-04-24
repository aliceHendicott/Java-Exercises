package oop.University;

public class Staff extends Academic {

    private int hours;

    public Staff(Title title, int id, String name){
        super(title, id, name);
    }

    public void setHours(int hours){
        this.hours = hours;
    }

    public double getWeeklyPay(){
        Title title = this.getTitle();
        double weeklyPay;
        if (title == Title.LECTURER){
            weeklyPay = 75000.0 / 52.0;
        } else{
            weeklyPay = hours * 35;
        }
        return weeklyPay;
    }

    public String toString(){
        int id = this.getID();
        String title = this.getTitle().toString();
        String str = "Staff " + id + " works as a " + title;
        return str;
    }

}
