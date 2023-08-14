package com.demoqa.tests;

import com.codeborne.selenide.Condition;
import com.demoqa.pages.TextBoxPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;

public class TextBox extends TestBase {

    TextBoxPage practiceTextBoxPage = new TextBoxPage();

    @Test
    void textBoxTest() {

        practiceTextBoxPage
                .textBoxPageOpen()
                .setFullName("Yuriy Lvatov")
                .setUserEmail("yuriy.lvatov@yandex.ru")
                .setCurrentAddress("Penza, Chebysheva, 16")
                .setPermanentAddress("Penza, Novozapadnaya, 41 (g)")

                .presSubmitButtonTB();

        practiceTextBoxPage
                .checkNameMod("Yuriy Lvatov")
                .checkEmailMod("yuriy.lvatov@yandex.ru")
                .checkCurrentAddressMod("Penza, Chebysheva, 16")
                .checkPermanentAddressMod("Penza, Novozapadnaya, 41 (g)");
    }

}
