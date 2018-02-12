package com.netapp.ads.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import com.netapp.ads.models.Preference;
import com.netapp.ads.models.projections.PreferenceProjections;



//@RepositoryRestResource(excerptProjection=PreferenceProjections.class)
@RepositoryRestResource
public interface PreferenceRepository extends JpaRepository<Preference, Integer>, JpaSpecificationExecutor<Preference> {

	List<Preference> findByPreferenceType(@Param("preferenceType") String preferenceType);
	
	Preference findByPreferenceTypeAndPageNameAndNativeUserIdAndCorpUserId(@Param("preferenceType") String preferenceType, @Param("pageName") String pageName, @Param("nativeUserId") Integer nativeUserId, @Param("corpUserId") Integer corpUserId);
	
}
