package br.com.turn2c.api.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {


    @Bean
    public OpenAPI customApi(){
        return new OpenAPI().
                info(new Info()
                        .title("API DESAFIO TURN2C")
                        .description("API QUE FOI CONSTRUIDA PARA O DESAFIO DE PLENO DA EMPRESA TURN2C")
                        .contact(new Contact().name("Guilherme Rodrigues").email("guelherme.contatos@gmail.com"))
                        .version("1.0.0"));
    }
}
