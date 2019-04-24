package oop.PastaModified;

public class Main {
    public static void main(String[] args) {

        // Instantiate a $12 Linguine pasta called p1
        PastaModified p1 = new PastaModified(PastaType.LINGUINE);

        // Instantiate a $14 Spaghetti pasta called p2
        PastaModified p2 = new PastaModified(PastaType.SPAGHETTI);

        // Fix the below print statements.
        System.out.println("p1 has price: " + p1.price());
        System.out.println("p2 has type: " + p2.type());

    }
}
