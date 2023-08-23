package ru.netology.web;

//import io.github.bonigarcia.wdm.WebDriverManager;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebTest1 {

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
    void testNegativeName1(){
        open("http://localhost:9999/");
        $("span[data-test-id=name] input").setValue("asd");
        $("span[data-test-id=phone] input").setValue("+79991234567");
        $("[data-test-id=agreement]").click();
        $("button[role=button]").click();
        $("[data-test-id=name].input_invalid").shouldHave(Condition.text("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }
    @Test
    void testNegativeName2(){
        open("http://localhost:9999/");
        //$("span[data-test-id=name] input").setValue("asd");
        $("span[data-test-id=phone] input").setValue("+79991234567");
        $("[data-test-id=agreement]").click();
        $("button[role=button]").click();
        $("[data-test-id=name].input_invalid").shouldHave(Condition.text("Поле обязательно для заполнения"));
    }
    @Test
    void testNegativePhone1(){
        open("http://localhost:9999/");
        $("span[data-test-id=name] input").setValue("Тыц Тыц Тыц-Тыц");
        $("span[data-test-id=phone] input").setValue("+799912345678");
        $("[data-test-id=agreement]").click();
        $("button[role=button]").click();
        $("[data-test-id=phone].input_invalid").shouldHave(Condition.text("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }
    @Test
    void testNegativePhone2(){
        open("http://localhost:9999/");
        $("span[data-test-id=name] input").setValue("Тыц Тыц Тыц-Тыц");
        //$("span[data-test-id=phone] input").setValue("+799912345678");
        $("[data-test-id=agreement]").click();
        $("button[role=button]").click();
        $("[data-test-id=phone].input_invalid").shouldHave(Condition.text("Поле обязательно для заполнения"));
    }
    @Test
    void testNegativeCheckbox(){
        open("http://localhost:9999/");
        $("span[data-test-id=name] input").setValue("Тыц Тыц Тыц-Тыц");
        $("span[data-test-id=phone] input").setValue("+79991234567");
        //$("[data-test-id=agreement]").click();
        $("button[role=button]").click();
        $("[data-test-id=agreement].input_invalid").shouldHave(Condition.cssValue("color", "rgba(255, 92, 92, 1)"));
    }
}
