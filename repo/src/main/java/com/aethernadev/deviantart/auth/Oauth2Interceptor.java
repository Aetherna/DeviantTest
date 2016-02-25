package com.aethernadev.deviantart.auth;

import android.util.Log;

import com.eccyan.optional.Optional;

import java.io.IOException;

import javax.inject.Singleton;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okio.Buffer;

/**
 * Created by Marta on 24/02/2016.
 */
@Singleton
public class Oauth2Interceptor implements Interceptor {

    private final Optional<String> accessToken;

    public Oauth2Interceptor(final Optional<String> accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public Response intercept(final Chain chain) throws IOException {
        final Request.Builder builder = chain.request().newBuilder();

        if (accessToken.isPresent()) {
            builder.addHeader("Authorization", "token " + accessToken.get());
        }

        final Request request = builder.build();
        logRequest(request);

        return chain.proceed(request);
    }

    private void logRequest(final Request request) throws IOException {
        final Buffer buffer = new Buffer();
        if (request.body() != null) {
            request.body().writeTo(buffer);
            Log.d("DEBUG", "Request to " + request.url().toString() + "\n" + buffer.readUtf8());
        }
    }
}
