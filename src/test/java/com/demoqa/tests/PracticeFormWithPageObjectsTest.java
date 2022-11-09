package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.PracticeFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
                .setName("FirstName1", "LastName1")
                .setMail("useremail1@email.com")
                .setGender("Female")
                .setNumber("9998887766")
                .setBirthDate("16", "December", "1993")
                .setSubject("English")
                .setHobby("Reading")
                .uploadFile("cat.jpg")
                .setCurrentAddress("Current Address")
                .setState("NCR")
                .setCity("Delhi")
                .submitForm();

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
                .setName("FirstName2", "LastName2")
                .setGender("Male")
                .setNumber("9998887766")
                .submitForm();

//        Check modal dialog
        practiceFormPage.checkTableAppearance()
                .checkValueInTable("Student Name", "FirstName2 LastName2")
                .checkValueInTable("Gender", "Male")
                .checkValueInTable("Mobile", "9998887766");
    }
}
