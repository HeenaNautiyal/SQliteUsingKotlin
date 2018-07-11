package com.example.caritas_heena.sqliteusingkotlin

import android.provider.BaseColumns

/**
 * Created by Caritas-Heena on 10-07-2018.
 */
object DBContract {
    /* Inner class that defines the table contents */
    class UserEntry : BaseColumns {
        companion object {
            val TABLE_NAME = "users"
            val COLUMN_USER_ID = "userid"
            val COLUMN_NAME = "name"
            val COLUMN_AGE = "age"
        }
    }
}