package com.demoqa.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class DropdownComponent {

    public DropdownComponent setSubject(String subject) {
        $("#subjectsInput").setValue(subject).pressEnter();
        return this;

    }

    public DropdownComponent setState(String state) {
        $("#react-select-3-input").setValue(state).pressEnter();
        return this;

    }

    public DropdownComponent setCity(String city) {
        $("#react-select-4-input").setValue(city).pressEnter();
        return this;

    }

}
