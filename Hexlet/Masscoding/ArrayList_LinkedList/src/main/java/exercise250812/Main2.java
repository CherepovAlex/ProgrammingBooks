package exercise250812;

import java.util.ArrayList;

public class Main2 {
    public static void main(String[] args) {
        // Список задач (строки) в виде лога, в этот лог можно дописывать новые задачи. Лог не модифицируется.
        // Считывается первая задача из лога и выполняется, но не удаляется.
        // Затем считывается следующая задача и т.д.

        LogQueue log = new LogQueue();

        log.add("Task :generateEffectiveLombokConfig");
        log.add("Task :processResources NO-SOURCE");
        log.add("Task :generateTestEffectiveLombokConfig");
        log.add("Task :processTestResource");
        log.add("Task :code:collectExternalDependenciesForSentry");

        String task = log.getCurrent();
        System.out.println(task); // Task :generateEffectiveLombokConfig
        //taskService.executive(task);

        log.add("Task :generateSentryBundleIdJava");
        log.add("Task :generateSentryDebugMetaPropertiesjava");
        log.add("Task :processResources");
        log.add("Task :generateEffectiveLombokConfig");

        String task1 = log.getCurrent();
        System.out.println(task1); // Task :generateEffectiveLombokConfig
        //taskService.executive(task);

        System.out.println(log.toString());
    }
}

class LogQueue {
    ArrayList<String> list;
        private int offset;

    LogQueue() {
        list = new ArrayList<>();
        offset = 0;
    }

    public void add(String s) {
        list.add(s);
    }

    public String getCurrent() {
        return list.get(offset++);
    }

    @Override
    public String toString() {
        return this.list.toString();
    }
}
