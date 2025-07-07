# Глава 7. Обработка аргументов командной строки
| 
|**Параметр**| **Подробности**|
|:-----------------------|:----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
|`args`| Аргументы командной строки. Если предположить, что метод `main` вызывается программой запуска java, при этом количество аргументов `args` содержит хотя бы один элемент и ни один их аргументов не равен `NULL`.|

## Раздел 7.1. Обработка аргументов с помощью GWT ToolBase

Если вы хотите разбирать более сложные аргументы командной строки, например с необязательными параметрами, то лучше всего использовать подход GWT от Google. Все классы находятся в открытом доступе по адресу: http://gwt.googlesource.com/gwt/+/2.8.0-beta1/dev/core/src/com/google/gwt/util/tools/ToolBase.java

Пример работы с командной строкой вида `myprogtam -dir "~Documents" -port 8888:`

```java
public class MyProgramHandler extends ToolBase {
    protected File dir;
    protected int port;
    // геттеры для dir и port
    ...
    
    public MyProgramHandler() {
        this.registerHandler(new ArgHandlerDir() {
            @Override
            public void setDir(File dir) {
                this.dir = dir;
            }
        });
        this.registerHandler(new ArgHandlerInt() {
            @Override
            public String[] getTagArgs() {
                return new String[]{"port"};
            }
            @Override
            public void setInt(int value) {
                 this.port = value;
            }
        });
    }

    public static void main(String[] args) {
        MyProgramHandler myShell = new MyProgramHandler();
        if (myShell.processArgs(args)) {
            // основное ядро программы
            System.out.println(String.format("port: %d; dir: %s", myShell.getPort(), myShell.getDir()));
        }
        System.exit(1);
    }
}
```

`ArgHandler` также содержит метод `isRequired()`, который может быть переопределён таким образом, чтобы выводилось сообщение об обязательном вводе в качестве аргумента хотя бы одного параметра в командной строке (по умолчанию на вход метода подаётся значение `false`, которое отменяет обязательный ввод аргумента).

[к оглавлению Глава 6](#глава-6-документирование-java-кода)

## Раздел 7.2. Обработка аргументов вручную



[к оглавлению Глава 6](#глава-6-документирование-java-кода)

[Раздел 7.1. Обработка аргументов с помощью GWT ToolBase](#раздел-71-обработка-аргументов-с-помощью-gwt-toolbase)

[Раздел 7.2. Обработка аргуметов вручную](#раздел-72-обработка-аргументов-вручную)