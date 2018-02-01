package com.netapp.ads.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.netapp.ads.models.UserNative;
import com.netapp.ads.projections.UserNativeWithUserRole;

//@Repository
@RepositoryRestResource(excerptProjection = UserNativeWithUserRole.class)
public interface UserNativeRepository extends JpaRepository<UserNative, Integer>, JpaSpecificationExecutor<UserNative>  {
	UserNative findFirstByEmail(@Param("email") String email);
	List<UserNative> findByUserName(@Param("user_name") String username);
	List<UserNative> findByEmail(@Param("email") String email);
}
