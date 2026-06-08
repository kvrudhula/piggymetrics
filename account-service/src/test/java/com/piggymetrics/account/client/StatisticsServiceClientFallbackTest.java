package com.piggymetrics.account.client;

import com.piggymetrics.account.domain.Account;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

@ExtendWith({SpringExtension.class, OutputCaptureExtension.class})
public class StatisticsServiceClientFallbackTest {

    @Test
    public void testUpdateStatisticsWithFailFallback(CapturedOutput output) {
        StatisticsServiceClientFallback fallback = new StatisticsServiceClientFallback();
        fallback.updateStatistics("test", new Account());

        assertThat(output.getErr() + output.getOut(), containsString("Error during update statistics for account: test"));
    }
}
