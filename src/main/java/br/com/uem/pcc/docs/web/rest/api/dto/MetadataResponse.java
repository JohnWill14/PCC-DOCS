package br.com.uem.pcc.docs.web.rest.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MetadataResponse {
    private String code;
    private String title;
    private LocalDateTime createFile;
    private LocalDateTime updateFile;
    private Long size;
}
