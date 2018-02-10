package com.uploaduck.vaadin;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

@SpringUI
@Theme("valo")
public class VaadinUi extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setContent(new Button("Click me", e -> Notification.show("hello there")));
    }
}