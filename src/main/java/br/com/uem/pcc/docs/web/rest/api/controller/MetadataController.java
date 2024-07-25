package br.com.uem.pcc.docs.web.rest.api.controller;

import br.com.uem.pcc.docs.pdf.storage.converter.ResponsesConverter;
import br.com.uem.pcc.docs.pdf.storage.document.Metadata;
import br.com.uem.pcc.docs.pdf.storage.service.PdfPccDocService;
import br.com.uem.pcc.docs.web.rest.api.dto.MetadataResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "pdfs", description = "....")
@AllArgsConstructor
public class MetadataController {

    @Autowired
    private final PdfPccDocService pdfPccDocService;

    @ApiResponse(responseCode = "200", description = "......", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)) })
    @GetMapping("/pdfs/metadatas/{id}")
    public ResponseEntity<?> getMetadata(@PathVariable String id) {
        Metadata meta = pdfPccDocService.findMetadataById(id);

        MetadataResponse metadataResponse = ResponsesConverter.convertMetadata(id, meta);

        return ResponseEntity.ok().body(metadataResponse);
    }
}
