package com.netapp.ads.repos;

import com.netapp.ads.models.PreferenceDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
* Generated by Spring Data Generator on 12/01/2018
*/
@RepositoryRestResource
public interface PreferenceDetailRepository extends JpaRepository<PreferenceDetail, Integer>, JpaSpecificationExecutor<PreferenceDetail> {

}
