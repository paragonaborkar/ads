package com.netapp.ads.repos;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.netapp.ads.models.UserNative;

@RepositoryRestResource
public interface UserNativeRepository extends PagingAndSortingRepository<UserNative, Long>  {

	List<UserNative> findByEmail(@Param("email") String email);
	
}
