package com.samspringproject.VehicleApp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.samspringproject.VehicleApp.models.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Integer> {

}
