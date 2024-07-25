package br.com.uem.pcc.docs.pdf.storage.converter;

import br.com.uem.pcc.docs.pdf.storage.document.Metadata;
import br.com.uem.pcc.docs.web.rest.api.dto.CodeResponse;
import br.com.uem.pcc.docs.web.rest.api.dto.MetadataResponse;

public class ResponsesConverter {
    public static CodeResponse convertCode(String code) {
        return CodeResponse.builder().code(code).build();
    }

    public static MetadataResponse convertMetadata(String code, Metadata metadata) {
        return MetadataResponse.builder().code(code).title(metadata.getTitle()).size(metadata.getSize()).createFile(metadata.getCreateFile()).updateFile(metadata.getUpdateFile()).build();
    }
}
