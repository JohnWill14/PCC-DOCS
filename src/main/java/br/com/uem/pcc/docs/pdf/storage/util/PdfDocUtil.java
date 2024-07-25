package br.com.uem.pcc.docs.pdf.storage.util;

import br.com.uem.pcc.docs.pdf.storage.document.Metadata;
import br.com.uem.pcc.docs.pdf.storage.document.PdfPccDoc;
import br.com.uem.pcc.docs.pdf.storage.exception.PdfDocErrorIOException;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;

public class PdfDocUtil {
    public static PdfPccDoc createPdfDoc(MultipartFile file){
        Binary binaryFromFile = getBinaryFromFile(file);
        return PdfPccDoc.builder().pdf(binaryFromFile).metadata(createNewMetadata(file)).build();
    }

    private static Binary getBinaryFromFile(MultipartFile file) {
        try {
            return new Binary(BsonBinarySubType.BINARY, file.getBytes());
        } catch (IOException e) {
            throw new PdfDocErrorIOException(e.getMessage());
        }
    }

    private static Metadata createNewMetadata(MultipartFile file){
        return Metadata.builder().title(file.getOriginalFilename()).createFile(LocalDateTime.now()).updateFile(LocalDateTime.now()).size(file.getSize()).build();
    }

}
