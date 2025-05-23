package com.ivanmyakishev.rbt.pages.web.mainPage;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginComponents {
    private final SelenideElement phoneNumberInput = $(".MaskInput_input__OqrYF");
    private final SelenideElement loginPopup = $(".AuthCodeModal_wrapper__toi92");
    private final SelenideElement loginButton = $(".PrimaryButton_button__TkLTD.AuthModal_button__FUJxa");
    private final SelenideElement phoneNumberErrorMessage = $(".ErrorMessage_error__WhbEA");

    @Step("Input phone number")
    public LoginComponents inputPhoneNumber(String phoneNumber) {
        phoneNumberInput.setValue(phoneNumber);
        return this;
    }

    @Step("Click on login button")
    public LoginComponents clickLoginButton() {
        loginButton.click();
        return this;
    }

    @Step("Check successful sending code")
    public void checkSuccessfulSendingCode() {
        loginPopup.shouldHave(text("Код подтверждения"));
    }

    @Step("Check error message for invalid phone number")
    public void checkErrorMessageForInvalidPhoneNumber() {
        phoneNumberErrorMessage.shouldBe(visible);
    }
}
