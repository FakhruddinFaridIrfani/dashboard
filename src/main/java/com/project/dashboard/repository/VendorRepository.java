package com.project.dashboard.repository;

import com.project.dashboard.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface VendorRepository extends JpaRepository<Vendor, Integer> {

    @Query(value = "SELECT * FROM dashboard.vendor where vendor_account_number = :account_number", nativeQuery = true)
    List<Vendor> getVendorByAccountNumber(@Param("account_number") String account_number);

}
