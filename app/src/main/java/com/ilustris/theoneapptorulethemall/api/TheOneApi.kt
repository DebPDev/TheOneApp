package com.ilustris.theoneapptorulethemall.api

import com.ilustris.theoneapptorulethemall.api.response.BooksResponse
import com.ilustris.theoneapptorulethemall.api.response.CharacterResponse
import com.ilustris.theoneapptorulethemall.api.response.MovieResponse
import com.ilustris.theoneapptorulethemall.network.API_KEY
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TheOneApi {

    @GET("character")
    suspend fun getCharacter(): CharacterResponse


    @GET("movies.json")
    suspend fun getMovie(): MovieResponse

    @GET("books.json")
    suspend fun getBook(): BooksResponse
}

