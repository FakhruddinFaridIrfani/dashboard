package com.project.dashboard.repository;

import com.project.dashboard.model.Budgeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface BudgetingRepository extends JpaRepository<Budgeting, Integer> {


    @Query(value = "SELECT * FROM dashboard.budgeting_transaction WHERE " +
            "(contract_number like :searchParameter OR invoice_number like :searchParameter ) AND budgeting_status like :budgeting_status AND data_status <> 'deleted' ORDER BY created_date DESC", nativeQuery = true)
    List<Budgeting> getBudgetList(@Param("searchParameter") String searchParameter, @Param("budgeting_status") String budgeting_status);


}
