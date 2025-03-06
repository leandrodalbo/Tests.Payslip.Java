package com.mhrglobal.print;

import com.mhrglobal.clients.PrinterClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PayslipPrintService implements PrintService {

    private final PrinterClient printerClient;
    Logger logger = LoggerFactory.getLogger(PayslipPrintService.class);

    public PayslipPrintService(PrinterClient printerClient) {
        this.printerClient = printerClient;
    }

    @Override
    public void requestPrinting(String role, String basePay, String overtime, String total) {
        this.printerClient.print(String.format("Role: %s, BasePay: £ %s, Overtime: £ %s, Total: £ %s\n", role, basePay, overtime, total));
        logger.info("Print called, Role: {}, BasePay: £{}, Overtime: £{}, Total: £{}", role, basePay, overtime, total);
    }
}
