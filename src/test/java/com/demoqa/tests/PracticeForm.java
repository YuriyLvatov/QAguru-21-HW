package com.demoqa.tests;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeForm extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void formTest() {

        registrationPage.openPage()
                .setFirstName("Yuriy")
                .setLastName("Lvatov")
                .setUserEmail("yuriy.lvatov@yandex.ru")
                .setGender("Male")
                .setUserNumber("9042693079")
                .setBirthDate("18","May", "1991")
                .setSubject("Maths")
                .setHobbie("Music")
                .selectPicture("ava.PNG")
                .setCurrentAddress("Bad and long history...")
                .selectStateAndCity("Haryana", "Karnal")

                        .submitPress();

        registrationPage.verifyRegistrationResultModalAppears()
                .verifyResult("Student Name","Yuriy Lvatov")
                .verifyResult("Student Email","yuriy.lvatov@yandex.ru")
                .verifyResult("Gender","Male")
                .verifyResult("Mobile","9042693079")
                .verifyResult("Date of Birth","18 May,1991")
                .verifyResult("Subjects","Maths")
                .verifyResult("Hobbies","Music")
                .verifyResult("Picture","ava.PNG")
                .verifyResult("Address","Bad and long history...")
                .verifyResult("State and City","Haryana Karnal")

                        .closeModalVerify();

    }
}