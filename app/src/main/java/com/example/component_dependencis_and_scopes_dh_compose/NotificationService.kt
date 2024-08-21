package com.example.component_dependencis_and_scopes_dh_compose

import android.util.Log
import com.example.component_dependencis_and_scopes_dh_compose.qualifiers.ActivityScope
import javax.inject.Inject

interface NotificationService{
    fun send (to:String,from:String,body:String)
}

@ActivityScope
class EmailService @Inject constructor():NotificationService{

    override fun send (to:String,from:String,body:String){
        Log.d("tagdaggerhilt", "email sent")
    }
}

class MessageService(private val retryCount:Int):NotificationService{
    override fun send(to: String, from: String, body: String) {
        Log.d("tagdaggerhilt", "message sent - retry:${retryCount}")
    }

}