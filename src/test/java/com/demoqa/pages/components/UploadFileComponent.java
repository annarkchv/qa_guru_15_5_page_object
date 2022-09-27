package com.demoqa.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class UploadFileComponent {

    public UploadFileComponent uploadFileFromClasspath(String fileName) {
        $("#uploadPicture").uploadFromClasspath(fileName);
        return this;

    }

}
