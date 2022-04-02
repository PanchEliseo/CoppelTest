package com.example.coppeltest.api

import com.squareup.moshi.JsonDataException
import com.squareup.moshi.Moshi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

// Wrapper class to manage different states
class NetworkResult<T>(val result: T? = null, val networkError: NetworkError? = null) {
    val isError: Boolean
        get() = networkError != null

    val requiredResult: T
        get() = result!!

    val requiredError: NetworkError
        get() = networkError!!
}

suspend fun <T> safeApiCall(apiCall: suspend () -> T): NetworkResult<T> {
    return withContext(Dispatchers.IO) {
        try {
            val response = apiCall.invoke()
            return@withContext NetworkResult(result = response)
        } catch (throwable: Throwable) {
            return@withContext NetworkResult<T>(networkError = createError(throwable))
        }
    }
}

private fun createError(throwable: Throwable): NetworkError {
    return when (throwable) {
        is IOException -> {
            NetworkError(NetworkErrorType.CONNECTION_ERROR, throwable.message)
        }
        is HttpException -> {
            val bodyResponse: String? = throwable.response()?.errorBody()?.string()
            NetworkError(
                NetworkErrorType.API_ERROR,
                bodyResponse,
                throwable.code().toString(),
                parseErrorBody(bodyResponse)
            )
        }
        is JsonDataException -> {
            NetworkError(NetworkErrorType.API_ERROR, throwable.message)
        }
        else -> {
            NetworkError(NetworkErrorType.UNKNOWN_ERROR, throwable.message)
        }
    }
}

private fun parseErrorBody(bodyResponse: String?): APIError? {
    return try {
        bodyResponse?.let {
            val moshiAdapter = Moshi.Builder().build().adapter(APIError::class.java)
            moshiAdapter.fromJson(it)
        }
    } catch (exception: Exception) {
        null
    }
}