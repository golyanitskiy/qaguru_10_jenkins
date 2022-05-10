package qaguru.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import qaguru.pages.RegistrationFormPage;

import static io.qameta.allure.Allure.step;

public class RegistrationFormPageTest {
    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @AfterAll
    static void closeDriver() {
        Selenide.closeWebDriver();
    }

    @Test
    void formFilling() {
        RegistrationFormPage page = new RegistrationFormPage();

        step("Open registration form", () -> {
            page.openPage();
        });

        step("Fill registration form", () -> {
            page.setFirstName()
                    .setSurname()
                    .setEmail()
                    .selectGender()
                    .setPhone()
                    .setBirthDate()
                    .setSubject()
                    .selectHobby()
                    .imageUpload()
                    .setAddress()
                    .setState()
                    .setCity();
        });

        step("Submit registration form", () -> {
            page.submitForm();
        });

        step("Verify form data", () -> page.checkFormResult()
                .closeConfirmation());
    }
}
