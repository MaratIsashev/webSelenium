package ru.netology.web;

//import io.github.bonigarcia.wdm.WebDriverManager;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class webTest1 {

    @Test
    //System.setProperty("webdriver.chrome.driver","driver/chromedriver");
    void testPositive(){
        open("http://localhost:9999/");
        $("span[data-test-id=name] input").setValue("Иванов-Петров Иван Иванович");
        $("span[data-test-id=phone] input").setValue("+79991234567");
        $("[data-test-id=agreement]").click();
        $("button[role=button]").click();
        $("[data-test-id=order-success]").shouldHave(Condition.text(" Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    void testNegative(){
        open("http://localhost:9999/");
        $("span[data-test-id=name] input").setValue("asd");
        $("span[data-test-id=phone] input").setValue("+79991234567");
        $("[data-test-id=agreement]").click();
        $("button[role=button]").click();
        $("[data-test-id=name]").shouldHave(Condition.text("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }
}
