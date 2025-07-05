package exercise;

import java.util.ArrayList;

public class Wrapper {
    public static void main(String[] args) {

        int x = 32;
        ArrayList list = new ArrayList();
        list.add(x);

        int i = 288;
//        Integer iWrap = new Integer(i);
//        int unWrapped = iWrap.intValue();

        ArrayList listOfNumbers = new ArrayList();
//        listOfNumbers.add(new Integer(3));
        Integer one = (Integer) listOfNumbers.get(0);
        int intOne = one.intValue();

        String s = "2";
        int x1 = Integer.parseInt(s);
        double d = Double.parseDouble("420.24");

//        boolean b = new Boolean("true").booleanValue();

        String t = "два";
        int y = Integer.parseInt(t); // NumberFormatException

        double d1 = 42.5;
        String doubleString = "" + d;

        double d2 = 42.5;
        String doubleString2 = Double.toString(d);

    }

    public void doNumsNewWay() {
        ArrayList<Integer> listOfNumbers = new ArrayList<Integer>();
        listOfNumbers.add(3);
        int num = listOfNumbers.get(0);
    }
}
