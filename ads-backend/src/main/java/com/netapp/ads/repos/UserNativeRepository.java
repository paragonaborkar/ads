package com.netapp.ads.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.netapp.ads.models.UserNative;

@Repository
public interface UserNativeRepository extends JpaRepository<UserNative, Integer>, JpaSpecificationExecutor<UserNative>  {

	UserNative findFirstByEmail(@Param("email") String email);
	
	List<UserNative> findByUserName(@Param("user_name") String username);
	List<UserNative> findByEmail(@Param("email") String email);
	
}
