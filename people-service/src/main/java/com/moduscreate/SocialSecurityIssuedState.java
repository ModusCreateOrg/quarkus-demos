package com.moduscreate;

import java.util.Arrays;

public enum SocialSecurityIssuedState {

    MAINE(new SocialSecurityIssuedStateRange[]{
            new SocialSecurityIssuedStateRange(4, 7)
    }),

    VIRGINIA(new SocialSecurityIssuedStateRange[]{
            new SocialSecurityIssuedStateRange(223, 231),
            new SocialSecurityIssuedStateRange(691, 699),
    });

    public final SocialSecurityIssuedStateRange[] socialSecurityPrefixes;

    SocialSecurityIssuedState(SocialSecurityIssuedStateRange[] socialSecurityPrefixes) {
        this.socialSecurityPrefixes = socialSecurityPrefixes;
    }

    public static class SocialSecurityIssuedStateRange {
        int start;
        int end;

        public SocialSecurityIssuedStateRange(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public boolean checkPrefixOnRange(int prefix) {
        return Arrays.stream(this.socialSecurityPrefixes).anyMatch(range -> prefix >= range.start && prefix <= range.end);
    }

}
