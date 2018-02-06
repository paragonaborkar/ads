package com.netapp.ads.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.netapp.ads.models.UserApi;

@RepositoryRestResource
public interface UserApiRepository extends JpaRepository<UserApi, Integer>, JpaSpecificationExecutor<UserApi> {
	
	List<UserApi> findByClientId(@Param("clientId") String clientId);

}
