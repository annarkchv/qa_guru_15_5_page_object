package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.AfterRegistrationComponent;
import com.demoqa.pages.components.CalendarComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {

    private CalendarComponent calendarComponent = new CalendarComponent();
    private AfterRegistrationComponent afterRegistrationComponent = new AfterRegistrationComponent();

    //    Elements
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            genderInput = $("#genterWrapper"),
            numberInput = $("#userNumber");

    //    Actions
    public PracticeFormPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;

    }

    public PracticeFormPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;

    }

    public PracticeFormPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;

    }

    public PracticeFormPage setGender(String gender) {
        genderInput.$(byText(gender)).click();
        return this;

    }

    public PracticeFormPage setNumber(String number) {
        numberInput.setValue(number);
        return this;

    }

    public PracticeFormPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
//    Календарь вынесен в отдельный компонент, т.к. может много где использоваться
        calendarComponent.setDate(day, month, year);
        return this;

    }

    public PracticeFormPage checkTableAppearance() {
        afterRegistrationComponent.checkTableAppearance();
        return this;

    }

    public PracticeFormPage checkValueInTable(String key, String value) {
        afterRegistrationComponent.checkValue(key, value);
        return this;

    }

}
