package com.netapp.ads.repos;

import com.netapp.ads.models.Ical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import com.netapp.ads.models.IcalPK;

/**
* Generated by Spring Data Generator on 22/12/2017
*/
@Repository
public interface IcalRepository extends JpaRepository<Ical, IcalPK>, JpaSpecificationExecutor<Ical> {

}
