package com.netapp.ads.repos;

import com.netapp.ads.models.Cutover;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
* Generated by Spring Data Generator on 28/01/2018
*/
@Repository
public interface CutoverRepository extends JpaRepository<Cutover, Integer>, JpaSpecificationExecutor<Cutover> {

}
