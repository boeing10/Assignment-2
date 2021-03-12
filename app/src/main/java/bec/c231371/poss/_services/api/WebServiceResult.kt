package bec.c231371.poss._services.api

data class WebServiceResult<T>(
    var result: String = "",
    var payload: T? = null
)