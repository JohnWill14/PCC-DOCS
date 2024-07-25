package br.com.uem.pcc.docs.web.rest.api.controller;

import br.com.uem.pcc.docs.pdf.storage.service.PdfPccDocService;
import br.com.uem.pcc.docs.pdf.storage.converter.ResponsesConverter;
import br.com.uem.pcc.docs.web.rest.api.dto.CodeResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Tag(name = "pdfs", description = "....")
@AllArgsConstructor
public class SaveNewPDFController {

    @Autowired
    private final PdfPccDocService pdfPccDocService;

    @ApiResponse(responseCode = "201", description = "....", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)) })
    @PostMapping(path = "/pdfs", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> saveNewPdf(@RequestBody MultipartFile pdf){
        String newCode = pdfPccDocService.saveNewPdf(pdf);
        CodeResponse codeResponse = ResponsesConverter.convertCode(newCode);
        return new ResponseEntity<>(codeResponse, HttpStatus.CREATED);
    }

}
