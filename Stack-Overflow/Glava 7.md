# Глава 7. Обработка аргументов командной строки

[Раздел 7.1. Обработка аргументов с помощью GWT ToolBase](#раздел-71-обработка-аргументов-с-помощью-gwt-toolbase)

[Раздел 7.2. Обработка аргуметов вручную](#раздел-72-обработка-аргументов-вручную)

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

[к оглавлению Глава 7](#глава-7-обработка-аргументов-командной-строки)

## Раздел 7.2. Обработка аргументов вручную

Если синтаксис командной строки приложения прост, целесообразно написать в теле программы свой собственный обработчик командной строки.

**Команда без аргументов**
В этом примере мы представим серию простых примеров. В каждом случае код будет выдавать сообщения об ошибках в случаях, если аргументы командной строки неприемлемы, после чего завершать программу вызовом `System.exit(1)`, чтобы сообщить оболочке о неудачном выполнении команды (В каждом случае предполагается, что Java-код вызывается с помощью обертки, имя которой - `"myapp"`).

```java
public class Main {
    public static void main(String[] args) {
        if (args.length > 0) {
            System.err.println("usage: myapp");
            System.exit(1);
        }
        // Запуск приложения
        System.out.println("Сработало");
    }
}
```

**Команда с двумя аргументами**
В данном случае команда требует не менее двух аргументов

```java
public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("usage: myapp <arg1> <arg2>");
            System.exit(1);
        }
        // Запуск приложения
        System.out.println("Сработало: " + args[0] + ", " + args[1]);
    }
}
```

Заметим, что если бы мы пренебрегали проверкой длины массива аргументов `args.length`, то команда аварийно завершилась бы в том случае, если бы пользователь запустил её со слишком малым количеством аргументов командной строки.

**Команда с несколькими опциями-"флагами" и хотя бы с одним аргументом**
В данном примере команда имеет несколько (необязательных) опций-флагов и требует как минимум один аргумент после опций.

```java
package tommy;
public class Main {
    public static void main(String[] args) {
        boolean feelMe = false;
        boolean seeMe = false;
        int index;
        loop: for (index = 0; index < args.length; index++) {
            String opt = args[index];
            switch (opt) {
                case "-c":
                    seeMe = true;
                    break;
                case "-f":
                    feelMe = true;
                    break;
                default:
                    if (!opts.isEmpty() && opts.charAt(0) == '-') {
                        error("Unknown option: '" + opt + "'");
                    }
                    break loop;
            }
        }
        if (index >= args.length) {
            error ("Missing argument(s)");
        }
        
        // Запуск приложения
        // ...
    }
    
    private static void error(String message) {
        if (message != null) {
            System.err.println(message);
        }
        System.err.println("usage: myapp [-f] [-c] [ <arg> ...]");
        System.exit(1);
    }
}
```

Как видно и приведённого выше примера, при сложном синтаксисе команды обработка аргументов становится достаточно громоздкой. В этом случае целесообразно воспользоваться библиотекой "разбора командной строки", см. другие примеры.

[к оглавлению Глава 7](#глава-7-обработка-аргументов-командной-строки)