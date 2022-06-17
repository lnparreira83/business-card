package com.lnp.businesscard

import android.app.Application
import com.lnp.businesscard.data.AppDatabase
import com.lnp.businesscard.data.BusinessCardRepository

class App : Application() {
    private var instance: App? = null

    val database by lazy { AppDatabase.getDatabase(this)}
    val repository by lazy { BusinessCardRepository(database.businessDao())}

}