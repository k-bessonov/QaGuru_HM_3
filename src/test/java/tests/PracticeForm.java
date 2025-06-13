package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000;
    }


    @Test
    void fillFormTest() {

        //Заполнение данных
        open("/automation-practice-form");
        $("#firstName").setValue("Имя");
        $("#lastName").setValue("Фамилия");
        $("#userEmail").setValue("mailfortest@test.test");
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue("8999999999");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1995");
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__day--001").click();

        /*интресно что GPT посоветовал делать так:
        $(".react-datepicker__day--015:not(.react-datepicker__day--outside-month)").click();
        чтобы не напороться на случай когда число встречается дважды и выбрать правильный месяц
        */

        $("#subjectsInput").setValue("Math").pressEnter();
        $("#subjectsInput").setValue("Physics").pressEnter();
        $("#subjectsInput").setValue("Computer Science").pressEnter();

        $("label[for='hobbies-checkbox-1']").click();
        $("label[for='hobbies-checkbox-3']").click();

        $("#currentAddress").setValue("Москва, Театральный проезд, 5с1");

        $("#state").click();
        $("#react-select-3-input").setValue("NCR").pressEnter();

        $("#city").click();
        $("#react-select-4-input").setValue("Gurgaon").pressEnter();

        //Нажимаем кнопку
        $("#submit").click();

        //Проверки


        //$("html").shouldHave(text("Об этой странице"));
    }
}
