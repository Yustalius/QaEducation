package com.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class YandexSearchPage {

    private final SelenideElement searchInput = $("#text");
    private final SelenideElement submitButton = $(".search3__button");

    public YandexSearchPage search(String query) {
        searchInput.setValue(query);
        return this;
    }

    public YandexSearchPage clickSearch () {
        submitButton.click();
        return this;
    }
}

