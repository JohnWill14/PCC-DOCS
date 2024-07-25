package br.com.uem.pcc.docs.pdf.storage.service;

import br.com.uem.pcc.docs.pdf.storage.document.Metadata;
import br.com.uem.pcc.docs.pdf.storage.document.PdfPccDoc;
import br.com.uem.pcc.docs.pdf.storage.exception.PdfDocNotFoundException;
import br.com.uem.pcc.docs.pdf.storage.gateway.PdfPccDocGateway;
import br.com.uem.pcc.docs.pdf.storage.util.PdfDocUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PdfPccDocServiceImpl implements PdfPccDocService {
    @Autowired
    private final PdfPccDocGateway pdfPccGate;
    @Autowired
    private PdfPccDocGateway pdfPccDocGateway;

    @Override
    public String saveNewPdf(MultipartFile file) {
        PdfPccDoc doc = PdfDocUtil.createPdfDoc(file);

        doc = pdfPccGate.insert(doc);

        return doc.getCode();
    }

    @Override
    public void updatePdf(String code, MultipartFile file) {
        PdfPccDoc pdfDoc = findPdfDoc(code);

        LocalDateTime createFileOriginalDate = pdfDoc.getMetadata().getCreateFile();

        PdfPccDoc newDoc = PdfDocUtil.createPdfDoc(file);

        newDoc.setCode(code);
        newDoc.getMetadata().setCreateFile(createFileOriginalDate);

        newDoc = pdfPccDocGateway.save(newDoc);
    }

    @Override
    public PdfPccDoc findPdfDoc(String id) {
        return pdfPccGate.findById(id).orElseThrow(PdfDocNotFoundException::new);
    }

    @Override
    public Metadata findMetadataById(String id) {
        Optional<PdfPccDoc> pdfPccOptional = pdfPccGate.findMetadataById(id);
        return pdfPccOptional.orElseThrow(PdfDocNotFoundException::new).getMetadata();
    }

    @Override
    public void removeById(String id) {
        pdfPccDocGateway.delete(findPdfDoc(id));
    }
}
