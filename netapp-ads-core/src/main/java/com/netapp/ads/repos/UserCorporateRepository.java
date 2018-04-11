package com.netapp.ads.repos;

import com.netapp.ads.models.Controller;
import com.netapp.ads.models.UserCorporate;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserCorporateRepository extends JpaRepository<UserCorporate, Integer>, JpaSpecificationExecutor<UserCorporate> {

	@Query("select count(e)>0 from UserCorporate e where e.email=:email")
	boolean isEmailExists(@Param("email") String email);
	
	UserCorporate findFirstByEmail(@Param("email") String email);
	
	UserCorporate findFirstByUserName(@Param("userName") String userName);
	
	List<UserCorporate> findByFirstNameContainingOrLastNameContaining(@Param("firstContains") String firstContains, @Param("lastContains") String lastContains);
	
}
