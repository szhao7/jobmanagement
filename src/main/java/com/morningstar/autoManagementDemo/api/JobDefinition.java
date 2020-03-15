package com.morningstar.autoManagementDemo.api;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobDefinition {
	@JsonProperty
	private long jobDefinitionId ;

	private String jobName ;

	private String testrailName;

	private String codeRepository;

	private String mailRecipientList;


	
}
