package com.netapp.repos;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.netapp.models.SourceStorage;


@RepositoryRestResource
public interface StorageSourceRepository extends PagingAndSortingRepository<SourceStorage, Long> {

	List<SourceStorage> findBySourceStorageName(@Param("name") String name);

}
