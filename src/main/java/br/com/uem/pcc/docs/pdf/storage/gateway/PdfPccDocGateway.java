package br.com.uem.pcc.docs.pdf.storage.gateway;

import br.com.uem.pcc.docs.pdf.storage.document.PdfPccDoc;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface PdfPccDocGateway extends MongoRepository<PdfPccDoc, String> {
    @Query(value = "{ 'code': ?0 }", fields = "{ 'metadata' : 1, _id : 0}")
    Optional<PdfPccDoc> findMetadataById(String id);
}
