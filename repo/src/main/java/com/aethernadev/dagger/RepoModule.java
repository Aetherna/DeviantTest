package com.aethernadev.dagger;

import com.aethernadev.deviantart.DeviantArtService;
import com.aethernadev.deviantart.auth.Oauth2Interceptor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Marta on 23/02/2016.
 */
@Module
public class RepoModule {


    @Provides
    @Singleton
    Retrofit provideRetrofit() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.deviantart.com/api/v1/oauth2")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit;
    }

    @Provides
    @Singleton
    DeviantArtService provideDeviantArtService(Retrofit retrofit) {
        return retrofit.create(DeviantArtService.class);

    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Oauth2Interceptor oauth2Interceptor) {
        final OkHttpClient client = new OkHttpClient();
        client.interceptors().add(oauth2Interceptor);
        return client;
    }
}
