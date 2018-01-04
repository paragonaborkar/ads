package com.netapp.repos;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.Projection;

import com.netapp.models.Host;

@RepositoryRestResource
public interface HostRepository extends PagingAndSortingRepository<Host, Integer> {

	List<Host> findByHostName(@Param("name") String name);

	@Projection(name = "summary", types = Host.class)
	public interface HostProjection {
		String getId();
		String getHostName();
	}
}
