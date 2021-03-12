package bec.c231371.poss.sales._models

import bec.c231371.poss._services.api.WebServiceResultList
import retrofit2.http.GET

interface ProductWebService {

    @GET("products")
    suspend fun getProducts(): WebServiceResultList<Product>

}
