package com.netapp.ads.repos;

import com.netapp.ads.models.WorkPackage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkPackageRepository extends CrudRepository<WorkPackage, Integer> {
}
