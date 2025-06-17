package com.cs492.frontend;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.oauth2.core.oidc.user.OidcUser;

public class Utilities {
    private Utilities() {
        throw new IllegalStateException("Utility class. Don't instantiate");
    }

    /**
     * Take a subset of ID Token claims and put them into KV pairs for UI to display.
     * @param principal OidcUser (see SampleController for details)
     * @return Map of filteredClaims
     */
    public static Map<String,String> filterClaims(OidcUser principal) {
        //final String[] claimKeys = {"sub", "aud", "ver", "iss", "name", "oid", "preferred_username"};
        //final List<String> includeClaims = Arrays.asList(claimKeys);

        Map<String,String> filteredClaims = new HashMap<>();
        // include all claims from the ID token
        principal.getIdToken().getClaims().forEach((key, value) -> {
            // if (includeClaims.contains(key)) {
                filteredClaims.put(key, value.toString());
            // }
        });

        return filteredClaims;
    }
}