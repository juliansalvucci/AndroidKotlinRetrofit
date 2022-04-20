package com.cursokotlin.retrofitkotlinexample

import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by aristidesguimeraorozco on 29/4/18.
 */
interface APIService {
    @GET
    fun getCharacterByName(@Url url: String): Call<DogsResponse>

    @GET("/example/example2/{id}/loquesea")  //Etiqueta path {} para identificar los parámetros.
    fun getCharacterByName2(@Path("id") id: String): Call<DogsResponse>

    @GET("/example/example2/v2/loquesea") //Para apis que reciben multiples parámetros.
    fun getCharacterByName3(
        @Query("pet") pet: String,  //Se utiliza la etiqueta query por parámetro.
        @Query("name") name: String
    ): Call<DogsResponse>

    @POST
    fun getEVERYTHING(@Body exampleArisDto: ExampleArisDto): Call<*>


    @Multipart   //Tipo de post por partes para poder guardar una imagen.
    @POST
    fun getEVERYTHING2(
        @Part image: MultipartBody.Part,
        @Part("example") myExample: String
    ): Call<*>

//    val requestBody =   RequestBody.create(MediaType.parse(getContentResolver().getType(fileUri)), file);
//    val a = MultipartBody.Part.createFormData("picture", file.getName(), requestBody);
}

//DTO  data transfer object
data class ExampleArisDto(val name: String, val age: Int) //Clase utilizada para hacer el post.