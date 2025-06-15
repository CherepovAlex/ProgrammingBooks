// Реализуйте публичный статический метод buildDefinitionList(), который генерирует HTML список определений
// (теги <dl>, <dt> и <dd>) и возвращает получившуюся строку. При отсутствии элементов в массиве метод
// возвращает пустую строку.
package exercise;

public class Main {
    public static String buildDefinitionList(String[][] definitions) {
        if (definitions.length == 0) {
            return "";
        }
        var result = new StringBuilder();
        result.append("<dl>");
        for (var definition : definitions) {
            var name = definition[0];
            var description = definition[1];

            result.append("<dt>");
            result.append(name);
            result.append("</dt>");

            result.append("<dd>");
            result.append(description);
            result.append("</dd>");
        }
        result.append("</dl>");

        return result.toString();
    }

    // END
    public static void main(String[] args) {
        // Метод принимает на вход список определения в виде двумерного массива:
        String[][] definitions1 = {
                {"definition1", "description1"},
                {"definition2", "description2"},
        };
        System.out.println("Hello world!");
        // То есть каждый элемент входного массива сам является массивом, содержащим два элемента: термин и его определение.
        System.out.println(Main.buildDefinitionList(definitions1));

        String[][] definitions2 = {
                {"Блямба", "Выпуклость, утолщения на поверхности чего-либо"},
                {"Бобр", "Животное из отряда грызунов"},
        };

        System.out.println(Main.buildDefinitionList(definitions2));
        // "<dl>
        //      <dt>Блямба</dt><dd>Выпуклость, утолщение на поверхности чего-либо</dd>
        //      <dt>Бобр</dt><dd>Животное из отряда грызунов</dd>
        // </dl>"
    }
}