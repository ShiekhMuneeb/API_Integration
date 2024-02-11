package com.example.apiintegration

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("pokemon?limit=10&offset=0")
    fun getData(): Call<PokemonListResponse>
}
