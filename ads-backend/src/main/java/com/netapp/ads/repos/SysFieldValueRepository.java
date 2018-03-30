package com.netapp.ads.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.netapp.ads.models.SysConfig;
import com.netapp.ads.models.SysFieldValue;


@Repository
public interface SysFieldValueRepository extends JpaRepository<SysFieldValue, Integer>, JpaSpecificationExecutor<SysConfig> {
	
	List<SysFieldValue> findByFieldName(@Param("fieldName") String fieldName);
	List<SysFieldValue> findByFieldNameAndFieldCascadeName(@Param("fieldName") String fieldName, @Param("fieldCascadeName") String fieldCascadeName);

}
