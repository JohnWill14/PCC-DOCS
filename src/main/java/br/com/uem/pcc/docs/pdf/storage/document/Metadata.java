package br.com.uem.pcc.docs.pdf.storage.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Metadata {

    private String title;
    private LocalDateTime createFile;
    private LocalDateTime updateFile;
    private Long size;
}
