package com.netapp.ads.repos;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.netapp.ads.models.UserApi;

@RepositoryRestResource
public interface UserApiRepository extends PagingAndSortingRepository<UserApi, Long>{
	
	List<UserApi> findByClientId(@Param("clientId") String clientId);

}
