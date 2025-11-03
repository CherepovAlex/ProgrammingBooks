package ru.yandex;

import java.util.List;

public class Main7 {

    // Producer: читаем животных (и их подклассы)
    void feedAll(List<? extends Animal> animals) {
        for(Animal a : animals) a.feed();
        // animals.add(new Animal()) - запрещено: тип конкретного подсписка неизвестен
    }

    // Consumer: добавляем собак в любой список предков собаки
    void addDefaultDog(List<? super Dog> dogs) {
        dogs.add(new Dog("dog"));  // разрешено
        // Dog d = dogs.get(0); // возвращается Object - безопасного даункаста нет
    }
}
