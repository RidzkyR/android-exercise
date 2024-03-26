package com.example.restaurantreview.data.retrofit

import com.example.restaurantreview.data.response.PostReviewResponse
import com.example.restaurantreview.data.response.RestaurantResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("detail/{id}") // melakukan permintaan HTTP GET ke server API
    fun getRestaurant(
        @Path("id") id: String // nilai id akan dimbil dari bagian url {id}
    ): Call<RestaurantResponse>

    // tambahan juga
    @FormUrlEncoded
    @Headers("Authorization: token 12345")
    @POST("review")
    fun postReview(
        @Field("id") id: String,
        @Field("name") name: String,
        @Field("review") review: String
    ): Call<PostReviewResponse>
}