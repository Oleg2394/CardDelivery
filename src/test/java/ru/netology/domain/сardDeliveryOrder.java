package ru.netology.domain;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;



public class сardDeliveryOrder {

    LocalDate today = LocalDate.now();
    LocalDate newDate = today.plusDays(3);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @Test
    void shouldSumbitRequest() {
        open("http://localhost:9999/");
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").doubleClick().sendKeys(formatter.format(newDate));
        $("[data-test-id=name] input").setValue("Иван Иванов");
        $("[data-test-id=phone] input").setValue("+71234567890");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();
        $(withText("Успешно!")).waitUntil(visible, 15000);
    }

    @Test
    void shouldSubmitRequestWithDropDownList() {
        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue("Бе");
        $$(".menu-item").first().click();
        $("[data-test-id=date]").click();
        $(".calendar__day_state_current").click();
        $("[data-test-id=name] input").setValue("Иван Иванов");
        $("[data-test-id=phone] input").setValue("+71234567890");
        $("[data-test-id=agreement]").click();
        $(By.className("button")).click();
        $(withText("Успешно!")).waitUntil(visible, 15000);
    }
}
