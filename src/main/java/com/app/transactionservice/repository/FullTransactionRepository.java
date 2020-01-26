package com.app.transactionservice.repository;

import com.app.transactionservice.modal.FullTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created By Shameera.A on 1/26/2020
 */
public interface FullTransactionRepository extends JpaRepository<FullTransaction, Long> {

    Optional<List<FullTransaction>> findByParentId(Long id);
}
