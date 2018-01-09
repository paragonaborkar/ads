package com.netapp.ads.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.netapp.ads.models.Activity;


@RepositoryRestResource
public interface ActivityRepository extends CrudRepository<Activity, Integer> {

}
