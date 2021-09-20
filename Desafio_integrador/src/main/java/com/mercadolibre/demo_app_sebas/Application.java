package com.mercadolibre.demo_app_sebas;

import com.mercadolibre.demo_app_sebas.config.SpringConfig;
import com.mercadolibre.demo_app_sebas.util.ScopeUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		ScopeUtils.calculateScopeSuffix();
		new SpringApplicationBuilder(SpringConfig.class).registerShutdownHook(true)
				.run(args);
	}
}
