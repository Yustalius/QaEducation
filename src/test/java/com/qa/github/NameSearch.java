package com.qa.github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class NameSearch {
    @Test
    void checkRepositories() {
        /*
         * Тест-кейс - проверить, что имя хозяина репы getting-started - Владислав Юстус
         * 1. открыть поисковик
         * 2. ввести данные сайта - Git Hub
         * 3. нажать кнопку поиск
         * 4. в поисковой выдаче найти нужный сайт, кликнуть на него
         * 5. нажать на поиск вправом верхнем углу
         * 6. Вставить в поиске "java-automation-qa/getting-started"
         * 7. нажать на Search all of GitHub
         * 8. Кликнуть на результат из выдачи
         * 9. Проверить, что имя владельца репы Владислав Юстус
         * */

        //Configuration.holdBrowserOpen = true; // браузер не закрывается после проверки
        Configuration.pageLoadTimeout = 100000; // таймаут прогрузги страницы
        Configuration.timeout = 100000; // таймаут прогрузги элементов

        open("https://ya.ru/");
        $("#text").setValue("Git Hub");
        $(".search3__button").click();
        $(".DistributionButtonClose_view_cross").click();
        $(byText("github.com")).click();

        switchTo().window(1);
        $(".header-search-button").click();
        $("#query-builder-test").setValue("java-automation-qa/getting-started");
        $(".ActionListItem-description").click();
        $(".hkFRpV").click();
        $$(".AuthorDisplayName-module__Text__OP5Q9").get(0).shouldHave(text("Владислав Юстус"));

    }
}
