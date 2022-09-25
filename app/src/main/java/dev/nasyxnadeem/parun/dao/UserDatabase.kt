package dev.nasyxnadeem.parun.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.nasyxnadeem.parun.model.User


@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase: RoomDatabase() {
    abstract fun userDao() : UserDao
}