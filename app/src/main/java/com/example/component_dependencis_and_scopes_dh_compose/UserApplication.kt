package com.example.component_dependencis_and_scopes_dh_compose

import android.app.Application
import com.example.singleton_annotation_and_scopes_compose.ConsumerComponent
import com.example.singleton_annotation_and_scopes_compose.DaggerConsumerComponent


/**
 * we have to impliment this class in the androidmanifest file in <application level like this:
 * android:name=".UserApplication"
 */


class UserApplication:Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate(){
        super.onCreate()

        appComponent = DaggerAppComponent.builder().build()


    }

}