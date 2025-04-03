package com.transfer.respository;

import com.transfer.model.TransactionDay;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionDayRepository extends JpaRepository<TransactionDay, Long> {

    @Modifying
    @Transactional
    @Query(value = "TRUNCATE TABLE transaction_day", nativeQuery = true)
    void truncateTransactionDay();

}
