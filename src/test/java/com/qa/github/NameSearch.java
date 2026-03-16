package com.qa.github;

import com.qa.pages.GitHubMainPage;
import com.qa.pages.YandexResultPage;
import com.qa.pages.YandexSearchPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class NameSearch {
    @Test
    void checkRepositories() {
        YandexSearchPage yandexSearchPage = new YandexSearchPage();
        YandexResultPage yandexResultPage = new YandexResultPage();
        GitHubMainPage gitHubMainPage = new GitHubMainPage();
        open("https://ya.ru/");

        yandexSearchPage
                .search ("Git Hub")
                .clickSearch ();

        yandexResultPage
                .closeDefaultWindow ()
                .openSiteGitHub ();

        gitHubMainPage
                .clickSearchMenu ()
                .searchTextMenu ("java-automation-qa/getting-started")
                .clickButtonSearch ()
                .openProjectGitHub ()
                .checkNameOwner ();

    }
}


//$("#text").setValue("Git Hub"); ready
//$(".search3__button").click(); ready
//$(".DistributionButtonClose_view_cross").click();
//$(byText("github.com")).click();
//
//switchTo().window(1);
//$(".header-search-button").click(); ready
//$("#query-builder-test").setValue("java-automation-qa/getting-started");
//$(".ActionListItem-description").click();
//$(".hkFRpV").click();
//$$(".AuthorDisplayName-module__Text__OP5Q9").get(0).shouldHave(text("Владислав Юстус"));




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
//Configuration.pageLoadTimeout = 100000; // таймаут прогрузги страницы
//Configuration.timeout = 100000; // таймаут прогрузги элементов