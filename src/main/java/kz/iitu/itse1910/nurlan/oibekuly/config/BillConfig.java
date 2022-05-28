package kz.iitu.itse1910.nurlan.oibekuly.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@Data
@DependsOn("meter_Reading")
@PropertySource(value = "application.properties", ignoreResourceNotFound = true)
public class BillConfig {

    private static Logger logger = LoggerFactory.getLogger(BillConfig.class);

    private Environment env;

    @Autowired
    public BillConfig(Environment env) {
        this.env = env;
    }

    public void billConfigRun() {
        logger.info("From Bill Environment");
        logger.info("Bill id: " + env.getProperty("bill.bill_id"));
        logger.info("Customer id: " + env.getProperty("bill.bill_customer_id"));
        logger.info("Bill number: " + env.getProperty("bill.bill_number"));
        logger.info("Amount: " + env.getProperty("bill.amount"));
        logger.info("Account: " + env.getProperty("bill.account"));
        logger.info("Description of payment: " + env.getProperty("bill.description"));
    }


}
