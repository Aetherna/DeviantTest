package com.aethernadev.deviantart;

import com.example.Image;

import java.util.List;

import retrofit2.Retrofit;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Marta on 23/02/2016.
 */
public class DeviantArtApi {

    private Retrofit retrofit;
    private DeviantArtService deviantArtService;

    public DeviantArtApi(final Retrofit retrofit, final DeviantArtService deviantArtService) {
        this.retrofit = retrofit;
        this.deviantArtService = deviantArtService;
    }

    public void getBrowseHot() {
        deviantArtService.getBrowseHot().map(new Func1<List<Image>, Observable<Image>>() {
            @Override
            public Observable call(final List<Image> images) {
                return Observable.from(images);
            }
        });
    }
}
