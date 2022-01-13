package com.real_estate.apioffline.api

import com.real_estate.apioffline.data.ContactList
import retrofit2.http.GET
import retrofit2.http.Headers

interface ContactListAPI {
    companion object{
        const val BASE_URL = "https://intern.docker-dev.d-tt.nl"
    }

    // The number of contacts can be varied using the size.
    // By default it is kept at 20, but can be tweaked.
    @Headers("Access-Key: 98bww4ezuzfePCYFxJEWyszbUXc7dxRx")
    @GET("/api/house")
    suspend fun getCarList() : List<ContactList>

}