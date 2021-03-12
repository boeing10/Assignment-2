package bec.c231371.poss._services.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class RoomTypeConverters {

    @TypeConverter
    fun stringArrayFromJson(json: String): List<String> {
        val listType: Type = object : TypeToken<ArrayList<String>>() {}.type
        return Gson().fromJson(json, listType)
    }

    @TypeConverter
    fun stringArrayToJson(list: List<String>): String {
        return Gson().toJson(list)
    }

}