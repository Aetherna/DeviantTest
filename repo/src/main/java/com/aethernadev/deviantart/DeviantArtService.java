package com.aethernadev.deviantart;

import com.aethernadev.deviantart.auth.AuthorizationResponse;
import com.example.Image;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Marta on 23/02/2016.
 */
public interface DeviantArtService {
    @GET("/browse/hot")
    Observable<List<Image>> getBrowseHot();

//    @GET("/token")
//    Observable<AuthorizationResponse> authorize(@Path("client_id"))

}
