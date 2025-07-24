package exercise.top20sobes;

// Напишите программу на Java, чтобы продемонстрировать явную проверку условий ожидания.

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class z11 {

    public static void main(String[] args) {
        // Указывает путь к исполняемому файлу chromedriver.exe (необходим для управления Chrome).
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
        // Создает объект для настройки Chrome.
        ChromeOptions cOptions = new ChromeOptions();
        // --disable-arguments – отключает некоторые аргументы браузера (возможна опечатка, вероятно, имелось в виду --disable-extensions).
        cOptions.addArguments("--disable-extensions");
        // Создает экземпляр ChromeDriver (открывается новое окно Chrome).
        WebDriver curentDriver = new ChromeDriver();
        // Максимизирует окно браузера.
        curentDriver.manage().window().maximize();
        // Устанавливает неявное ожидание 20 секунд для всех операций поиска элементов
        // (если элемент не найден сразу, WebDriver будет ждать до 20 сек.).
        curentDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        // Открывает Google (украинская версия).
        curentDriver.navigate().to("https://www.google.com.ru");
        // Находит поле поиска Google по атрибуту name="q".
        WebElement curentElement = curentDriver.findElement(By.name("q"));
        // Вводит текст "Testing" в поле поиска.
        curentElement.sendKeys("Testing");
        // Отправляет форму поиска (аналог нажатия Enter).
        curentElement.submit();
        // Создает объект для явного ожидания (максимум 20 секунд).
        WebDriverWait waitWD = new WebDriverWait(curentDriver, 20);
        // Ожидает появления ссылки, содержащей текст "Тестирование программного обеспечения - Википедия".
        // visibilityOfElementLocated проверяет, что элемент не только существует в DOM, но и виден на странице.
        WebElement secondElement = waitWD.until
                (ExpectedConditions.visibilityOfElementLocated(By.partialLinkText
                        ("Тестирование программного обеспечения - Википедия")));
        // Кликает по найденной ссылке (переход на статью в Википедии).
        secondElement.click();
        // Закрывает браузер и освобождает ресурсы.
//        curentDriver.quit();
    }
}
