package com.moduscreate;

import static org.junit.jupiter.api.Assertions.*;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

public class SocialSecurityIssuedStateTest {

    @Test
    public void testIfPrefixMatchesWithState() {

        assertTrue(SocialSecurityIssuedState.VIRGINIA.checkPrefixOnRange(224));
        assertTrue(SocialSecurityIssuedState.VIRGINIA.checkPrefixOnRange(223));
        assertTrue(SocialSecurityIssuedState.VIRGINIA.checkPrefixOnRange(231));
        assertTrue(SocialSecurityIssuedState.VIRGINIA.checkPrefixOnRange(691));
        assertTrue(SocialSecurityIssuedState.VIRGINIA.checkPrefixOnRange(692));
        assertTrue(SocialSecurityIssuedState.VIRGINIA.checkPrefixOnRange(699));
        assertFalse(SocialSecurityIssuedState.VIRGINIA.checkPrefixOnRange(10));

    }

}
