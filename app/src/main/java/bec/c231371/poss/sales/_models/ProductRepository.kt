package bec.c231371.poss.sales._models

import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

@ViewModelScoped
class ProductRepository @Inject constructor(
    private val service: ProductWebService,
    private val dao: ProductDao
) {

    suspend fun refresh() = withContext(Dispatchers.IO) {
        // Call the JSON API (get new data)
        val response = service.getProducts()

        // Save the new data in local db
        dao.replaceProducts(response.payload)
    }

    fun getProduct(): Flow<List<Product>> = dao.getProducts()

    fun getProductByBarcode(code: String): Flow<Product> = dao.getProductByBarcode(code)

    suspend fun updateProduct(
        oldBarcode: String,
        newBarcode: String,
        name: String,
        priceSatang: Int,
        category: String
    ) = withContext(Dispatchers.IO) {
        dao.replaceProduct(oldBarcode, Product(newBarcode, name, priceSatang, category))
    }

}
