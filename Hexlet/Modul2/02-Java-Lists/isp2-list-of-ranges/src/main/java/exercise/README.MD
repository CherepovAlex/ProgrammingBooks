src/main/java/io/hexlet/App.java
В классе App реализуйте публичный статический метод summaryRanges(), который принимает в качестве параметра список целых чисел List<Integer>. Метод должен найти в списке непрерывные возрастающие на единицу последовательности чисел и вернуть список List<String> с их перечислением

var ranges1 = App.summaryRanges(new ArrayList<Integer>());
System.out.println(ranges1); // => []

var ranges2 = App.summaryRanges(List.of(1));
System.out.println(ranges2); // []

var ranges3 = App.summaryRanges(List.of(1, 2, 3));
System.out.println(ranges3); // [1->3]

var ranges4 = App.summaryRanges(List.of(0, 1, 2, 4, 5, 7));
System.out.println(ranges4); // [0->2, 4->5]

var ranges5 = App.summaryRanges(List.of(110, 111, 112, 111, -5, -4, -2, -3, -4, -5));
System.out.println(ranges5); // [110->112, -5->-4]