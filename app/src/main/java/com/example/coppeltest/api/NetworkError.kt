package com.example.coppeltest.api

enum class NetworkErrorType {
    CONNECTION_ERROR,
    API_ERROR,
    UNKNOWN_ERROR
}

// Represents a Standard Error from Parrot API
data class APIError(
    val code: String,
    val message: String
)

data class NetworkError(
    var type: NetworkErrorType,
    var rawError: String? = null,
    var errorCode: String? = null,
    var apiError: APIError? = null
) {
    val ensureErrorMessage: String
        get() {
            apiError?.let {
                return it.message
            }

            rawError?.let {
                return it
            }

            return type.name
        }
}
