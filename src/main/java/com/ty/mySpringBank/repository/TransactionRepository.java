package com.ty.mySpringBank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.mySpringBank.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

	List<Transaction> findByAccountId(int id);
}
