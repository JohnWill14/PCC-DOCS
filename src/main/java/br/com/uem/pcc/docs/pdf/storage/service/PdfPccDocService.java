package br.com.uem.pcc.docs.pdf.storage.service;

import br.com.uem.pcc.docs.pdf.storage.document.Metadata;
import br.com.uem.pcc.docs.pdf.storage.document.PdfPccDoc;
import org.springframework.web.multipart.MultipartFile;

public interface PdfPccDocService {
    String saveNewPdf(MultipartFile file);
    void updatePdf(String code, MultipartFile file);
    PdfPccDoc findPdfDoc(String id);
    Metadata findMetadataById(String id);
    void removeById(String id);
}
