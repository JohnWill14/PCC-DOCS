package br.com.uem.pcc.docs.pdf.storage.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pdfs")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PdfPccDoc {

    @Id
    private String code;
    private Metadata metadata;
    private Binary pdf;
}
