package dev.nasyxnadeem.parun.model

data class SignupResponse(
    private val token : String? = null,
    private val status: String? = null,
    private val message: String? = null,
    private val data: User? = null
)
