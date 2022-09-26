package com.demoqa.pages.components;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AfterRegistrationComponent {

    public AfterRegistrationComponent checkTableAppearance() {
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(exactText("Thanks for submitting the form"));
        return this;

    }

    public AfterRegistrationComponent checkValue(String key, String value) {
        $(".table-responsive").$(byText(key)).parent().shouldHave(exactText(key + " " + value));
        return this;

    }
}
