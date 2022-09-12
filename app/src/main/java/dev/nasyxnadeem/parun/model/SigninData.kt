package dev.nasyxnadeem.parun.model

data class SigninData(
    val email: String? = null,
    val password: String? = null
)

data class SigninResponse(
    val token: String? = null,
    val message: String? = null,
    val data: User? = null
)


