package com.ilustris.theoneapptorulethemall.api.response

data class CharacterResponse (val docs: List<CharacterDataResponse>){


}

data class CharacterDataResponse(
    val id: String, val race: String, val birth:String, val gender: String, val death: String, val name: String, val height: String, )


