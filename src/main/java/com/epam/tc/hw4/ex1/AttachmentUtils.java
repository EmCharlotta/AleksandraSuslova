package com.epam.tc.hw4.ex1;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import java.util.List;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AttachmentUtils {

    public void attachString(String attachmentName, String attachment) {
        Allure.addAttachment(attachmentName, attachment);
    }

    @Attachment
    public String makeStringAttachment(List<String> collection) {
        return collection.toString();
    }

    @Attachment(type = "image/png", value = "Try to use name {attachmentName}")
    public byte[] attachPngImage(String attachmentName, byte[] source) {
        return source;
    }
}
