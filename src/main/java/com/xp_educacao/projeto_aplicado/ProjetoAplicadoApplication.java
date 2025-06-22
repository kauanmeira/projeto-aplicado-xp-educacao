package com.xp_educacao.projeto_aplicado;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Projeto aplicado - API REST",
				version = "1.0.0",
				description = "API REST para gerenciamento de clientes - Desafio Final do Bootcamp de Arquiteto de Software",
				license = @License(
						name = "MIT License",
						url = "https://opensource.org/licenses/MIT"
				)
		)
)
public class ProjetoAplicadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoAplicadoApplication.class, args);
	}

}
