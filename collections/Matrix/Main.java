package coll.Matrix;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Matrix<String> m = new Matrix<String>(3, 3);

        m.insert(0, 0, "a");
        m.insert(0, 1, "b");
        m.insert(0, 2, "c");
        m.insert(1, 0, "d");
        m.insert(1, 1, "e");
        m.insert(1, 2, "f");
        m.insert(2,0, "g");
        m.insert(2, 1, "h");
        m.insert(2, 2, "i");

        String str = m.toString();
        String str2 = m.get(0, 1);
        System.out.println(str);

        Iterator<String> iterator = m.iterator();
        System.out.print("[");
        while (iterator.hasNext())
            System.out.print(iterator.next());
        System.out.print("]");
    }
}
