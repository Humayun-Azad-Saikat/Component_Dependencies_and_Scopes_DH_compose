package com.example.component_dependencis_and_scopes_dh_compose

import android.util.Log
import com.example.component_dependencis_and_scopes_dh_compose.qualifiers.ActivityScope
import javax.inject.Inject

interface UserRepository{
    fun saveUser(user:String,email:String)
}

// to be sure that which leve singliton this we can use our own annotation class insted of @Singleton that is in my case @ApplicationLevelSingleton
@ActivityScope
class SQLrepository @Inject constructor(val analyticsService: AnalyticsService):UserRepository {
    override fun saveUser(user:String, email:String){
        Log.d("tagdaggerhilt", "user saved in sqlDB")
        analyticsService.trackEvent("saveuser","create")
    }
}

class FirebaseRepository(val analyticsService: AnalyticsService):UserRepository{
    override fun saveUser(user:String, email:String){
        Log.d("tagdaggerhilt", "user saved in firebase")
        analyticsService.trackEvent("saveuser","create")
    }
}