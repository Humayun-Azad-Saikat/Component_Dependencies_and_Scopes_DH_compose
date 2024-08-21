package com.example.component_dependencis_and_scopes_dh_compose

import com.example.component_dependencis_and_scopes_dh_compose.modules.AnalyticsModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AnalyticsModule::class])
interface AppComponent {

    fun getAnalyticsService():AnalyticsService

}