package exercise.Vebinar15;

public class StringPoolExample {

    public static void main(String[] args) {

        String str1 = "TopJava";
        String str2 = "TopJava";
        System.out.println("String 1 equals string 2? " + (str1 == str2)); // true

        String str3 = "TopJava";
        String str4 = "Top" + "Java";
        System.out.println("String 3 equals string 4? " + (str3 == str4)); // true
        // склейка также идёт в StringPool

        String str5 = "TopJava";
        String str6 = "Java";
        String str7 = "Top" + str6;
        System.out.println("String 5 equals string 7? " + (str5 == str7)); // false
        // объект образован во время компиляции

        String str8 = "TopJava";
        String str9 = "TopJava";
        String str10 = new String("TopJava");
        String str11 = new String("TopJava");
        System.out.println("String 8 equals string 9? " + (str8 == str9));   // true
        System.out.println("String 9 equals string 10? " + (str9 == str10)); // false
        System.out.println("String 10 equals string 1? " + (str10 == str11));// false

        String str12 = "TopJava";
        String str13 = "TopJava";
        String str14 = new String("TopJava").intern();
        String str15 = new String("TopJava").intern();
        System.out.println("String 12 equals string 13? " + (str12 == str13));   // true
        System.out.println("String 13 equals string 14? " + (str13 == str14)); // true
        System.out.println("String 14 equals string 15? " + (str14 == str15)); // true

    }

}
