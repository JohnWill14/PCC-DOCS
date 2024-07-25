package br.com.uem.pcc.docs.pdf.storage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

@Component
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class PdfDocErrorIOException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public PdfDocErrorIOException() {
        super();
    }

    public PdfDocErrorIOException(String message) {
        super(message);
    }

    public PdfDocErrorIOException(Throwable cause) {
        super(cause);
    }

}