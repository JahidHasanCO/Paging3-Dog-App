package dev.jahidhasanco.paging3_dogapp.netwok

import dev.jahidhasanco.paging3_dogapp.data.model.Dogs
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    // api_key=327774f5-ffd5-47e0-974c-96953958d0b5

    companion object{
        const val BASE_URL = "https://api.thedogapi.com"
    }

    @GET("v1/images/search")
    suspend fun getAllDogs(
        @Query("page") page:Int,
        @Query("limit") limit:Int
    ):List<Dogs>
}

