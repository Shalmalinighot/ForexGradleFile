package com.sprint.forex.service;

import com.sprint.forex.dto.ReportDto;

public interface ReportService {
  
    byte[] generateReport(ReportDto reportDto);
    ReportDto generateReport(int transactionId);
}