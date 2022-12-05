package com.project.dashboard.repository;

import com.project.dashboard.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface BankAccountRepository extends JpaRepository<BankAccount,Integer> {


}
