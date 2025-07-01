package exercise;

import java.util.ArrayList;

public class DotComBust {
    // Объявляем и инициализируем переменные, которые нам понадобятся
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>(); // только для DotCom
    private int numOfGuesses = 0;

    private void setUpGame() {
        // Создадим несколько "сайтов" (3 объекта DotCom) и присвоим им имена
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        one.setName("eToys.com");
        DotCom three = new DotCom();
        one.setName("Go2.com");
        // помещаем им в ArrayList
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);
        // выводим краткие инструкции для пользователя
        System.out.println("Ваша цель - потопить три \"сайта\".");
        System.out.println("Pets.com, eToys.com, Go2.com");
        System.out.println("Попытайтесь потопить их за минимальное количество ходов");
        // повторяем с каждым объектом DotCom в списке
        for (DotCom dotComToSet : dotComsList) {
            // запрашиваем у вспомогательного объекта адрес сайта
            ArrayList<String> newLocation = helper.placeDotCom(3);
            // запрашивает сеттер, чтобы передать местоположение, полученнное выше
            dotComToSet.setLocationCells(newLocation);
        }
    }

    private void startPlaying() {
        // пока список объектов DotCom не станет пустым
        while (!dotComsList.isEmpty()) {
            // получаем пользовательский ввод
            String userGuess = helper.getUserInput("Сделайте ход");
            // вызвываем метод проверки
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess) {
        numOfGuesses++; // увеличиваем попытки
        String result = "Мимо"; // по-умолчанию - промах
        // повторяем для всех в списке
        for (DotCom dotComToTest : dotComsList) {
            // проверяем/ищем попадание/потопление
            result = dotComToTest.checkYourself(userGuess);
            if (result.equals("Попал")) {
                break; // выходим сразу раз попал
            }
            if (result.equals("Потопил")) {
                dotComsList.remove(dotComToTest);
                break; // выходим раньше раз потопил
            }
        }
        System.out.println(result); // печатаем итог выстрела
    }
    // выводим итоговые слова
    private void finishGame() {
        System.out.println("Все \"сайты\" ушли ко дну! Ваши акции теперь ничего не стоят.");
        if (numOfGuesses <= 18) {
            System.out.println("Это заняло у вас всего" + numOfGuesses + "попыток.");
            System.out.println("Вы успели выбраться до того, как ваши вложения утонули");
        } else {
            System.out.println("Это заняло у вас довольно много времени. " + numOfGuesses + " попыток.");
            System.out.println("Рыбы водят хороводы вокруг ваших вложений");
        }
    }

    public static void main(String[] args) {
        DotComBust game = new DotComBust(); // создаём игру - объект
        game.setUpGame();       // говорим - подготовить игру
        game.startPlaying();    // говорим - начать новый игровой цикл
    }
}
