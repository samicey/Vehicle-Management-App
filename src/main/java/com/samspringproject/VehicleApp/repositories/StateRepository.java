package com.samspringproject.VehicleApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.samspringproject.VehicleApp.models.States;

@Repository
public interface StateRepository extends JpaRepository<States, Integer> {

}
