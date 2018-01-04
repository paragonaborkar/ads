package com.netapp.repos;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.netapp.models.Host;
import com.netapp.models.MigrationProject;

@RepositoryRestResource
public interface MigrationProjectRepository extends PagingAndSortingRepository<MigrationProject, Long> {

	List<Host> findByMigrationProjectName(@Param("name") String name);

}
