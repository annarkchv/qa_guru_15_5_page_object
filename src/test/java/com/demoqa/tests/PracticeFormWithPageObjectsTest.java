package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.PracticeFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PracticeFormWithPageObjectsTest {

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";

    }

    @Test
    void fillFormTest() {

//        Fill form
        practiceFormPage.openPage()
                .setFirstName("FirstName1")
                .setLastName("LastName1")
                .setGender("Female")
                .setNumber("9998887766")
                .setBirthDate("16", "December", "1993");
        $("#userEmail").setValue("useremail1@email.com");
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("cat.jpg");
        $("#currentAddress").setValue("Current Address");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();

//        Check modal dialog
        practiceFormPage.checkTableAppearance()
                .checkValueInTable("Student Name", "FirstName1 LastName1")
                .checkValueInTable("Student Email", "useremail1@email.com")
                .checkValueInTable("Gender", "Female")
                .checkValueInTable("Mobile", "9998887766")
                .checkValueInTable("Date of Birth", "16 December,1993")
                .checkValueInTable("Subjects", "English")
                .checkValueInTable("Hobbies", "Reading")
                .checkValueInTable("Picture", "cat.jpg")
                .checkValueInTable("Address", "Current Address")
                .checkValueInTable("State and City", "NCR Delhi");

    }

    @Test
    void fillFormWithMinimumDataTest() {

//        Fill form
        practiceFormPage.openPage()
                .setFirstName("FirstName2")
                .setLastName("LastName2")
                .setGender("Male")
                .setNumber("9998887766");
        $("#submit").click();

//        Check modal dialog
        practiceFormPage.checkTableAppearance()
                .checkValueInTable("Student Name", "FirstName2 LastName2")
                .checkValueInTable("Gender", "Male")
                .checkValueInTable("Mobile", "9998887766");

    }

}
