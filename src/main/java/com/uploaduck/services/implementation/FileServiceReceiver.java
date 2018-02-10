package com.uploaduck.services.implementation;

import com.vaadin.ui.Upload;
import java.io.OutputStream;

public class FileServiceReceiver implements Upload.Receiver, Upload.SucceededListener {

    @Override
    public OutputStream receiveUpload(String filename, String mimeType) {
        return null;
    }

    @Override
    public void uploadSucceeded(Upload.SucceededEvent succeededEvent) {

    }
}
