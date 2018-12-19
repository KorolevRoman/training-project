package training.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@ImportResource("spring_mvc_config.xml")
@SpringBootApplication
public class TrainingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainingApplication.class, args);
	}

	@Bean
	public Docket postApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("organization")
				.apiInfo(apiInfo())
				.select()
				.paths(regex("/*"))
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Spring REST Sample with Swagger")
				.description("Spring REST Sample with Swagger")
				.version("1.0")
				.build();
	}
}
