package com.morningstar.autoManagementDemo.db.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.morningstar.autoManagementDemo.api.JobDefinition;


public class JobDefinitionMapper implements  ResultSetMapper<JobDefinition> {

    public JobDefinition map(int index, ResultSet resultSet, StatementContext statementContext) throws SQLException {
       return new JobDefinition(resultSet.getInt("job_definition_id"), resultSet.getString("job_name"),resultSet.getString("testrail_name"), 
    		   resultSet.getString("code_repository"), resultSet.getString("mail_recipient_list"));
    }
 
}
