package br.com.uem.pcc.docs.pdf.storage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

@Component
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PdfDocNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public PdfDocNotFoundException() {
        super();
    }

    public PdfDocNotFoundException(String message) {
        super(message);
    }

    public PdfDocNotFoundException(Throwable cause) {
        super(cause);
    }

}