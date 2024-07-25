package br.com.uem.pcc.docs.web.config.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Songs back-end", version = "1.0", description = "api rest song website"))
public class SwaggerConfig {
}
