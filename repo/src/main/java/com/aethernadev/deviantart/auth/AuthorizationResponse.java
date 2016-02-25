package com.aethernadev.deviantart.auth;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Marta on 24/02/2016.
 */
public class AuthorizationResponse {
    @SerializedName("access_token")
    private String accessToken;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(final String accessToken) {
        this.accessToken = accessToken;
    }
}
