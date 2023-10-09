package com.demoqa.tests;


import com.demoqa.pages.RegistrationPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;


public class PracticeForm extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void formTest() {

        Faker faker = new Faker(new Locale("en"));

        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                userEmail = faker.internet().emailAddress(),
                streetAddress = faker.address().streetAddress(),
                userNumberPhone = faker.phoneNumber().subscriberNumber(10);


        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender("Male")
                .setUserNumber(userNumberPhone)
                .setBirthDate("18","May", "1991")
                .setSubject("Maths")
                .setHobbie("Music")
                .selectPicture("ava.PNG")
                .setCurrentAddress(streetAddress)
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
