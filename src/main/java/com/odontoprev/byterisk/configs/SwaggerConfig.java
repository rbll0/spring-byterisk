package com.odontoprev.byterisk.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("ByteRisk API")
                        .version("1.0")
                        .description("API para a aplicação ByteRisk da OdontoPrev, focado em redução de sinistros odontológicos.")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}

