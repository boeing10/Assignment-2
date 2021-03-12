package bec.c231371.poss._services.database

import androidx.room.Database
import androidx.room.RoomDatabase
import bec.c231371.poss.sales._models.Product
import bec.c231371.poss.sales._models.ProductDao


@Database(entities = [Product::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun ProductDao(): ProductDao

}

