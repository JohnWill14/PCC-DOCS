package br.com.uem.pcc.docs.web.handler;

import br.com.uem.pcc.docs.pdf.storage.exception.PdfDocErrorIOException;
import br.com.uem.pcc.docs.pdf.storage.exception.PdfDocNotFoundException;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(PdfDocNotFoundException.class)
    public ResponseEntity<?> userNotFoundException(PdfDocNotFoundException notFoundRequestException) {
        String message = notFoundRequestException.getMessage();
        String details = StringUtils.isNotEmpty(message) ? message : "pdf not found";

        return new ResponseEntity<>(
                RequestExceptionDetails.builder().timeStamps(LocalDateTime.now()).status(HttpStatus.NOT_FOUND.value())
                        .title("Not found Exception, try again").details(details)
                        .developerMessge(notFoundRequestException.getClass().getName()).build(),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PdfDocErrorIOException.class)
    public ResponseEntity<?> userNotFoundException(PdfDocErrorIOException badRequestException) {
        String message = badRequestException.getMessage();
        String details = StringUtils.isNotEmpty(message) ? message : "error reading pdf";
        return new ResponseEntity<>(
                RequestExceptionDetails.builder().timeStamps(LocalDateTime.now()).status(HttpStatus.BAD_REQUEST.value())
                        .title("Not found Exception, try again").details(details)
                        .developerMessge(badRequestException.getClass().getName()).build(),
                HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
                                                             HttpStatusCode statusCode, WebRequest request) {

        String message = ex != null ? ex.getMessage():null;

        String cause = ex!=null && ex.getCause() != null ? ex.getCause().toString():null;

        String classname = ex!=null ? ex.getClass().getSimpleName():null;

        return new ResponseEntity<>(
                RequestExceptionDetails.builder().timeStamps(LocalDateTime.now())
                        .status(statusCode.value()).title(cause)
                        .details(message).developerMessge(classname).build(),
                statusCode);
    }

    @Builder
    @Data
    private static class RequestExceptionDetails {
        protected String title;
        protected int status;
        protected String details;
        protected String developerMessge;
        @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
        protected LocalDateTime timeStamps;

    }

}
