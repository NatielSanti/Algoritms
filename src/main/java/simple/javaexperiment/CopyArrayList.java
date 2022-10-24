package simple.javaexperiment;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CopyArrayList {
    public static void main(String[] args) {
        List<Integer> inner = new ArrayList<>();
        inner.add(1);
        inner.add(10);
        inner.add(100);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(inner);

        List<List<Integer>> newOuter = new ArrayList<>();

        Collections.copy(newOuter, outer);

        System.out.println(newOuter.size());
        newOuter.get(0).set(0, 2);
        newOuter.get(0).set(0, 11);
        newOuter.get(0).set(0, 101);

        System.out.println(inner);
    }
}
