package com.example.singleton_annotation_and_scopes_compose


import com.example.component_dependencis_and_scopes_dh_compose.AppComponent
import com.example.component_dependencis_and_scopes_dh_compose.EmailService
import com.example.component_dependencis_and_scopes_dh_compose.MainActivity
import com.example.component_dependencis_and_scopes_dh_compose.modules.AnalyticsModule
import com.example.component_dependencis_and_scopes_dh_compose.modules.NotificaionServiceModule
import com.example.component_dependencis_and_scopes_dh_compose.modules.UserRepositoryModule
import com.example.component_dependencis_and_scopes_dh_compose.qualifiers.ActivityScope
import dagger.BindsInstance
import dagger.Component


//this is activity level component

@ActivityScope
@Component(dependencies = [AppComponent::class], modules = [UserRepositoryModule::class, NotificaionServiceModule::class])
interface ConsumerComponent {

    fun injectMainAC(mainActivity: MainActivity)

    fun getEmailservice(): EmailService


    @Component.Factory
    interface Factory{
        fun create(@BindsInstance retryCount:Int, appComponent: AppComponent):ConsumerComponent
    }

}