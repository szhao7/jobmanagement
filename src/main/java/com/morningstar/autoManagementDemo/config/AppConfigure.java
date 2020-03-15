package com.morningstar.autoManagementDemo.config;

import java.util.Collections;
import java.util.Map;


import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import lombok.Data;

@Data
public class AppConfigure extends Configuration {

    private DataSourceFactory database = new DataSourceFactory();
    
    private Map<String, Map<String, String>> viewRendererConfiguration = Collections.emptyMap();
    

	@JsonProperty("swagger")
    public SwaggerBundleConfiguration swaggerBundleConfiguration;
}
