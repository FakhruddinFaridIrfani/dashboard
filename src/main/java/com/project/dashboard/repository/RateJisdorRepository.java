package com.project.dashboard.repository;

import com.project.dashboard.model.RateJisdor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface RateJisdorRepository extends JpaRepository<RateJisdor, Integer> {


    @Query(value = "SELECT * FROMd dashboard.rate_jisdor ORDER BY created_date DESC limit 1", nativeQuery = true)
    List<RateJisdor> getLatestRateJisdor();
}
