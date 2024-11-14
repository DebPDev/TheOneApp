package com.ilustris.theoneapptorulethemall.api

import com.ilustris.theoneapptorulethemall.network.RetrofitConfig

class TheOneService : RetrofitConfig(){

    suspend fun getCharacter() = retrofitConfig.create(TheOneApi::class.java).getCharacter()
    suspend fun  getMovie () = retrofitConfig.create(TheOneApi::class.java).getMovie()
    suspend fun  getBook() = retrofitConfig.create(TheOneApi::class.java).getBook()
}

