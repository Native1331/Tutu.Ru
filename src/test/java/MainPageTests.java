import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("TutuRuTests")
public class MainPageTests extends TestBase {


    @ValueSource(strings = {
            "Санкт-Петербург",
            "Москва"
    })
    @ParameterizedTest(name = "Search tickets from different cities{0}")
    void chooseAviaIickets(String testData) {
        $(byName("city_from")).val(testData);
        $$(".wrapper").get(0).click();
        $(byName("city_to")).val("Москва");
        $$(".wrapper").get(1).click();
        $(byName("date_from")).val("01.01.2023").pressEnter();
        $(byName("date_back")).val("02.01.2023").pressEnter();
        $$("[class=hl6eWku54t2D-JLA0KOvn]")
                .find(Condition.text(testData))
                .shouldBe(visible);
    }

    @Tag("TutuRuTests")
    @Test
    @DisplayName("Find railway tickets")
    void chooseTrainTickets() {
        step("Find  ticket", () -> {
            $(".tab_train").click();
            $(byName("schedule_station_from")).val("Симферополь");
            $("li:nth-child(1) > .list_item").click();
            $(byName("schedule_station_to")).click();
            $(byName("schedule_station_to")).val("Анап").click();
            $$(".j-city_from_suggest_container").get(1).click();
            $(".j-date_to").val("01.08.2022").pressEnter();
            $("._68Sr6IM8-eKoi8iow9l1e").shouldHave(text("Симферополь"));

        });
    }
    @Tag("TutuRuTests")
    @Test
    @DisplayName("Find ElectricTrain tickets")
    void chooseElectricTrainIickets() {
        $(".tab_etrain").click();
        $(byName("st1")).val("Санкт-Петербург");
        $("li:nth-child(1) > .list_item").click();
        $(byName("st2")).val("Зеленого");
        $$(".j-city_from_suggest_container").get(1).click();
        $$(".j-date_to").get(1).val("01.08.2022").pressEnter();
        $(".b-etrain__schedule_title").shouldHave(text("Зеленогорск"));
    }

    @Tag("TutuRuTests")
    @Test
    @DisplayName("Find a tour")
    void lookingForATour() {
        $(byLinkText("Туры")).click();
        $(byName("departure")).click();
        $$(".c02684").get(1).click();
        $(byName("arrival")).click();
        $(byName("arrival")).val("Мальдивы").pressEnter();
        $(".c02544").click();
        $(".DayPicker-Body").click();
        $$(".DayPicker-Month").get(1).click();
        $$(".DayPicker-Week").get(0).click();
        $$(".DayPicker-Day").get(1).click();
        $$(".c02549").get(0).click();
        $(".c02577").click();
        $(".j-tours_container_content").shouldHave(text("Мальдивы"));
    }
    @Tag("TutuRuTests")
    @Test
    @DisplayName("Find all adventures in Russia")
    void findAdventure() {
        $(byText("Приключения")).click();
        $(".order-group-input").click();
        $$(".o33499").get(4).click();
        $(".o33493").shouldHave(text("Норвегия"));
    }
    @Tag("TutuRuTests")
    @Test
    @DisplayName("Look the shedule of Aeroexpress")
    void findTheSheduleOfAeroexpress() {
        $(".tab_aeroexpress").click();
        $(".Stepper__link__5ESnh").click();
        $(".b-aeroexpress_schedule").shouldHave(text("Расписание Аэроэкспресса"));
    }
}

