package dev.nasyxnadeem.parun.dao

import androidx.room.*
import dev.nasyxnadeem.parun.model.User
import kotlinx.coroutines.flow.Flow


@Dao
interface UserDao {

    @Query("SELECT * FROM token_tbl")
    fun getToken(): Flow<User>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateToken(user: User)

    @Delete
    suspend fun deleteToken(unit: Unit)

}