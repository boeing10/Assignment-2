package bec.c231371.poss._services.api

data class WebServiceResultList<T>(
    var result: String = "",
    var count: Int = 0,
    var payload: List<T> = emptyList()
)