package com.cs492.frontend;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.security.oauth2.core.oidc.user.OidcUser;

public class Utilities {
    private Utilities() {
        throw new IllegalStateException("Utility class. Don't instantiate");
    }

    /**
     * Take a subset of ID Token claims and put them into KV pairs for UI to display.
     * @param principal OidcUser (see SampleController for details)
     * @return Map of Claims
     */
    public static Map<String,String> getClaims(OidcUser principal) {

        Map<String,String> Claims = new HashMap<>();
        // include all claims from the ID token
        principal.getIdToken().getClaims().forEach((key, value) -> {            
                Claims.put(key, value.toString());            
        });

        // include a few claims needed for the Pizza API
        // convert the sub UUID claim to a long
        String oid = principal.getAttribute("oid");
        UUID oid_UUID = UUID.fromString(oid);
        long cartId = Math.abs(oid_UUID.getLeastSignificantBits());

        Claims.put("cartId", Long.toString(cartId));

        return Claims;
    }
}