package com.uploaduck.vaadin;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import com.vaadin.ui.Upload;

@SpringUI
@Theme("valo")
public class VaadinUi extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        UploadReceiver receiver = new UploadReceiver();
        Upload upload = new Upload("Upload it here", receiver);
        upload.setImmediateMode(false);
        upload.setButtonCaption("Upload Now");
        setContent(upload);
    }
}