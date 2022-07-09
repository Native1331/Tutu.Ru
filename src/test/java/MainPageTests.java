import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class MainPageTests extends TestBase{
    @Test
    @DisplayName("Open main page")
    void OpenAllMainPagesTest(){
        step("OpenMainPage",() -> {
            /**Авиабилеты
             Ввести: Санкт-Петербург-Калининград-01.01.2023
             Нажать Найти билеты
             Ж/д билеты
             Ввести: Санкт-Петербург-Москва-01.01.2023
             Нажать Найти билеты
             Автобусы
             Ввести: Симферополь-Анапа-01.01.2023
             Нажать Найти билеты
             Заказ гостиниц
             Ввести: Москва-01.01.2023-03.01.2023
             Туры
             Ввести: Санкт-Петербург-Турция-01.01.2023-на 2 ночи-
             на 1 взрослого
             Нажать Найти туры
             Приключения
             Ввести:Безопасность оплаты
             Проверить актуальность ссылок
             Командировки
             Ввести:Мальдивы-Найти приключения
             Проверить актуальность ссылок
             Аэроэкспрессы
             Проверить расписание**/
        }
    }
}

