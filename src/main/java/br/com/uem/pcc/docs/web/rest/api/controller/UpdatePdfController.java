package br.com.uem.pcc.docs.web.rest.api.controller;

import br.com.uem.pcc.docs.pdf.storage.service.PdfPccDocService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Tag(name = "pdfs", description = "....")
@AllArgsConstructor
public class UpdatePdfController {

    @Autowired
    private final PdfPccDocService pdfPccDocService;

    @ApiResponse(responseCode = "204", description = "....", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)) })
    @PutMapping(path = "/pdfs", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> updatePdf(@RequestParam("code") String id, @RequestBody MultipartFile pdf){
        pdfPccDocService.updatePdf(id, pdf);
        return ResponseEntity.noContent().build();
    }

}
