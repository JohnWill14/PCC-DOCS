package br.com.uem.pcc.docs.web.rest.api.controller;

import br.com.uem.pcc.docs.pdf.storage.document.PdfPccDoc;
import br.com.uem.pcc.docs.pdf.storage.service.PdfPccDocService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "pdfs", description = "....")
@AllArgsConstructor
public class DownloadPdfController {

    @Autowired
    private final PdfPccDocService pdfPccDocService;

    @ApiResponse(responseCode = "200", description = "....",  content = @Content(mediaType = "application/json",
            schema = @Schema(type = "String", format = "byte")))
    @GetMapping("/pdfs/{id}")
    public ResponseEntity<?> getPdf(@PathVariable String id) {
        PdfPccDoc pdfDocs = pdfPccDocService.findPdfDoc(id);
        ByteArrayResource download = new ByteArrayResource(pdfDocs.getPdf().getData());

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + pdfDocs.getMetadata().getTitle());
        headers.add(HttpHeaders.CONTENT_TYPE, "application/pdf");
        headers.add(HttpHeaders.CONTENT_LENGTH, String.valueOf(download.contentLength()));

        return ResponseEntity.ok()
                .headers(headers)
                .body(download);
    }

}
