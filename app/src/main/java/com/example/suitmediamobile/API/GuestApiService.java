package com.example.suitmediamobile.API;

import com.squareup.moshi.Moshi;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;
import retrofit2.http.GET;

public interface GuestApiService {
    @GET("596dec7f0f000023032b8017")
    Call<ListGuest> getGuest();

    Moshi moshi = new Moshi.Builder().build();
    Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl("http://www.mocky.io/v2/")
            .build();

    GuestApiService service = retrofit.create(GuestApiService.class);
}
