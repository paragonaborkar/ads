package com.netapp.repos;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.netapp.models.DataCenter;

@RepositoryRestResource
public interface DataCenterRepository extends PagingAndSortingRepository<DataCenter, Integer> {

	List<DataCenter> findByDataCenterName(@Param("name") String name);

}
