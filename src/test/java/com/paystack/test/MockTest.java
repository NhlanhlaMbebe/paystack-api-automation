package com.paystack.test;

import com.paystack.model.Automation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockTest {

    //mocks out the response and returns a different value for the name object
    @Test
    public void testMockResponse() {
        Automation automation = mock(Automation.class);
        when(automation.getName()).thenReturn("Nhlanhla")
                .thenReturn("Imit");

        assertEquals("Nhlanhla", automation.getName());
        assertEquals("Imit", automation.getName());
    }
}
