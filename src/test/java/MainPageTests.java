import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class MainPageTests extends TestBase {
    @Test
    @DisplayName("Find Avia tickets")
    void chooseAviaIickets() {
        $(byName("city_from")).val("Санкт-Петербург");
        $$(".wrapper").get(0).click();
        $(byName("city_to")).val("Москва");
        $$(".wrapper").get(1).click();
        $(byName("date_from")).val("01.01.2023").pressEnter();
        $(byName("date_back")).val("02.01.2023").pressEnter();
        $("[class=hl6eWku54t2D-JLA0KOvn]").shouldHave(Condition.text("Санкт-Петербург"));
    }


    @Test
    @DisplayName("Find railway tickets")
    void chooseTrainIickets() {
        step("Find  ticket", () -> {
            $(".tab_train").click();
            $(byName("schedule_station_from")).val("Симферополь");
            $("li:nth-child(1) > .list_item").click();
            $(byName("schedule_station_to")).click();
            $(byName("schedule_station_to")).val("Анап").click();
            $$(".j-city_from_suggest_container").get(1).click();
            $(".j-date_to").val("01.08.2022");
            $(".button_wrp:nth-child(6) .spinner").click();
            executeJavaScript("window.scrollTo(0,0)");
            $("[class=_18ehmEN08IkbP9f2lo805b]").shouldHave(Condition.text("Симферополь"));
        });
    }

    @Test
    @DisplayName("Find ElectricTrain tickets")
    void chooseElectricTrainIickets() {
        $(".tab_etrain").click();
        $(byName("st1")).val("Санкт-Петербург");
        $("li:nth-child(1) > .list_item").click();
        $(byName("st2")).val("Зеленого");
        $$(".j-city_from_suggest_container").get(1).click();
        $(byName("date_arrow_to")).val("01.08.2022");
        $(".button_wrp:nth-child(6) .spinner").click();
        executeJavaScript("window.scrollTo(0,0)");
        $("[class=_18ehmEN08IkbP9f2lo805b]").shouldHave(Condition.text("Зеленогорск"));
    }

    @Test
    @DisplayName("Find and Booking a hotel")
    void bookingAHotel() {
       $(".new_project > .ico").click();
        $(".o33541").click();
        $(".o33541").val("Сочи, Краснодарский край, Россия");


}


/**
 * /**
 *
 * Заказ гостиниц
 * Ввести: Москва-01.01.2023-03.01.2023
 * Туры
 * Ввести: Санкт-Петербург-Турция-01.01.2023-на 2 ночи-
 * на 1 взрослого
 * Нажать Найти туры
 * Приключения
 * Ввести:Безопасность оплаты
 * Проверить актуальность ссылок
 * Командировки
 * Ввести:Мальдивы-Найти приключения
 * Проверить актуальность ссылок
 * Аэроэкспрессы
 * Проверить расписание
 **/


