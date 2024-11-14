package com.ilustris.theoneapptorulethemall.api.response

data class BooksResponse(
    val books: List<BookResponse>
)
data class BookResponse (
    val title: String,
    val publishDate: String,
    val pages: Int,
    val cover: String,
    val description: String,
    val production: List<ProductionResponse>
)
    data class ProductionResponse(
        val role: String,
        val name: String,
    )



