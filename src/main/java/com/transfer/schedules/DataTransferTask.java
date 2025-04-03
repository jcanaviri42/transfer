package com.transfer.schedules;

import com.transfer.services.TransactionScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataTransferTask {

    private final TransactionScheduleService transactionService;

    // Run every 3 minutes
    @Scheduled(cron = "0 */3 * * * *")
    public void transferDataDaily() {
        transactionService.transferData();
    }
}
