package com.demoqa.tests;


import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.demoqa.utils.RandomUtils.getRandomCity;
import static com.demoqa.utils.RandomVariables.*;


public class PracticeForm extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void formTest() {

        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstNameValue)
                .setLastName(lastNameValue)
                .setUserEmail(emailValue)
                .setGender(genderValue)
                .setUserNumber(phoneNumber)
                .setBirthDate(dayValue,monthValue, yearValue)
                .setSubject(subjectValue)
                .setHobbie(hobbyValue)
                .selectPicture(pictureNameValue)
                .setCurrentAddress(addressValue)
                .selectStateAndCity(stateValue, cityValue)

                .submitPress();

        registrationPage.verifyRegistrationResultModalAppears()
                .verifyResult("Student Name", firstNameValue + " " + lastNameValue)
                .verifyResult("Student Email", emailValue)
                .verifyResult("Gender", genderValue)
                .verifyResult("Mobile", phoneNumber)
                .verifyResult("Date of Birth", dayValue + " " + monthValue + "," + yearValue)
                .verifyResult("Subjects", subjectValue)
                .verifyResult("Hobbies", hobbyValue)
                .verifyResult("Picture", pictureNameValue)
                .verifyResult("Address", addressValue)
                .verifyResult("State and City", stateValue + " " + cityValue)

                .closeModalVerify();

    }
}
