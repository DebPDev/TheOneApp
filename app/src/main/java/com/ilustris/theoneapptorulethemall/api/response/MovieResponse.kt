package com.ilustris.theoneapptorulethemall.api.response

data class MovieResponse (val movies: List<MovieDataResponse>)

data class MovieDataResponse(

    val id: String,
    val title: String,
    val description : String,
    val year : Int,
    val duration: Int,
    val rate: String,
    val metaScore: Int,
    val cover: String

)

//"title": "The Lord of the Rings: The Fellowship of the Ring",
//"description": "A meek Hobbit from the Shire and eight companions set out on a journey to destroy the powerful One Ring and save Middle-earth from the Dark Lord Sauron.",
//"year": 2001,
//"duration": 178,
//"rate": "PG-13",
//"metaScore": 92,
//"cover":"https://m.media-amazon.com/images/M/MV5BNzIxMDQ2YTctNDY4MC00ZTRhLTk4ODQtMTVlOWY4NTdiYmMwXkEyXkFqcGc@._V1_.jpg"