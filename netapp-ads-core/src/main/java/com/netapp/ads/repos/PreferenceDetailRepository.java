package com.netapp.ads.repos;

import com.netapp.ads.models.PreferenceDetail;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;


@RepositoryRestResource
public interface PreferenceDetailRepository extends JpaRepository<PreferenceDetail, Integer>, JpaSpecificationExecutor<PreferenceDetail> {
	
	List<PreferenceDetail> findByFieldVisible(@Param("fieldVisible") int fieldVisible);
	
}
