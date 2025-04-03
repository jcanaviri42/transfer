package com.transfer.schedules;

import com.transfer.services.TransactionScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@SuppressWarnings("unused")
public class DataTransferTask {

    @Autowired
    private TransactionScheduleService transactionService;

    // Run every 2 minutes
    @Scheduled(cron = "0 */2 * * * *")
    public void transferDataDaily() {
        transactionService.transferData();
    }
}
