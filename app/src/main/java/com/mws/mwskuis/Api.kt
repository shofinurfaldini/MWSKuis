package com.mws.mwskuis

import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("quotes")
    fun getQuotes() : Call<ArrayList<QuotesResponse>>
}