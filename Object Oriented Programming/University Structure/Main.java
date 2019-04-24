package oop.University;

public class Main {

    public static void main(String[] args){

        Student s1 = new Student(Title.BACHELOR_STUDENT, 3, "Alice", 20);
        String str1 = s1.toString();
        double p1 = s1.getWeeklyPay();
        System.out.println(str1);
        System.out.println(p1);

        System.out.println();

        Staff s2 = new Staff(Title.TUTOR, 56, "Bob");
        s2.setHours(20);
        String str2 = s2.toString();
        double p2 = s2.getWeeklyPay();
        System.out.println(str2);
        System.out.println(p2);

        Staff s3 = new Staff(Title.LECTURER, 56, "Tracy");
        s3.setHours(20);
        String str3 = s3.toString();
        double p3 = s3.getWeeklyPay();
        System.out.println(str3);
        System.out.println(p3);

    }

}
