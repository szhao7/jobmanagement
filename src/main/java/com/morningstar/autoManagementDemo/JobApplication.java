package com.morningstar.autoManagementDemo;

import java.nio.charset.StandardCharsets;

import com.morningstar.autoManagementDemo.config.AppConfigure;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JobApplication extends Application<AppConfigure> {
	@Override
	public void initialize(Bootstrap<AppConfigure> bootstrap) {
		bootstrap.addBundle(new AssetsBundle());
		
		bootstrap.addBundle(new SwaggerBundle<AppConfigure>() {
			@Override
			protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(AppConfigure configuration) {
				return configuration.getSwaggerBundleConfiguration();
			}

			@Override
			public void run(AppConfigure configuration, Environment environment) throws Exception {
				super.run(configuration, environment);
			}

		});
	
	}
	

	@Override
	public void run(AppConfigure configuration, Environment environment) throws Exception {
	}
	
	public static void main(String[] args) throws Exception {
		log.info("hello dropwizard.");
		new JobApplication().run(args);
	}

}
