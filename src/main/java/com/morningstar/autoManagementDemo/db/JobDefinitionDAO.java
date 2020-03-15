package com.morningstar.autoManagementDemo.db;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import com.morningstar.autoManagementDemo.api.JobDefinition;
import com.morningstar.autoManagementDemo.db.mapper.JobDefinitionMapper;



@RegisterMapper(JobDefinitionMapper.class)
public interface  JobDefinitionDAO {

	@SqlQuery("select * from Job_definition")
	List<JobDefinition> getAll();

    @SqlQuery("select * from Job_definition where Job_definition_id = :jobDefinitionId")
    JobDefinition findById(@Bind("jobDefinitionId") int id);

    @SqlUpdate("delete from Job_definition where Job_definition_id = :jobDefinitionId")
    int deleteById(@Bind("jobDefinitionId") int id);

    @SqlUpdate("update Job_definition set JOB_NAME = :jobName where Job_definition_id = :jobDefinitionId")
    int update(@BindBean JobDefinition team);

    @SqlUpdate("insert into Job_definition (job_definition_id, job_name,testrail_name,code_repository,mail_recipient_list) "
    		+ "values (:jobDefinitionId, :jobName,:testrailName,:codeRepository,:mailRecipientList)")
    int insert(@BindBean JobDefinition team);
    
}
