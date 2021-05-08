package com.epam.consumer;

import com.epam.consumer.flow.QuoterConsumerFlowManager;
import com.epam.infra.ApplicationContext;
import com.epam.infra.JavaConfig;
import lombok.SneakyThrows;


public class MainConsumer {
    @SneakyThrows
    public static void main(String[] args) {

        ApplicationContext context = new ApplicationContext(JavaConfig.builder().packagesToScan("com.epam").build());
        QuoterConsumerFlowManager flowManager = context.getObject(QuoterConsumerFlowManager.class);

        while(true) {
            flowManager.saveQuoteFilesAsJson();
            //Thread.sleep(10000);
        }
    }
}
