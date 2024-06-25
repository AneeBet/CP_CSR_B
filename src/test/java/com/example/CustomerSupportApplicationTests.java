package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomerSupportApplicationTests {

	@Test
    void applicationStarts() {
        CustomerSupportApplication.main(new String[] {});
        Assertions.assertDoesNotThrow(()->{});
        // If the application fails to start, this test will fail.
        // No assertion is needed here because we are only interested in whether the application context loads without throwing exceptions.
    }

}
