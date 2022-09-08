package dev.nasyxnadeem.parun.model

data class SignupResponse(
     val token : String? = null,
     val status: String? = null,
     val message: String? = null,
    val data: User? = null
)
