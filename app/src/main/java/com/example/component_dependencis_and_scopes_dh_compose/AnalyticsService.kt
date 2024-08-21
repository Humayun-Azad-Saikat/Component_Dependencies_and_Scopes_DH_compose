package com.example.component_dependencis_and_scopes_dh_compose

import android.util.Log

interface AnalyticsService {
    fun trackEvent(eventName:String,eventType:String)
}

class Mixpanel:AnalyticsService{
    override fun trackEvent(eventName: String, eventType: String) {
        Log.d("Event", "trackEvent: $eventName $eventType")
}


class FirebaseAnalytics:AnalyticsService {
    override fun trackEvent(eventName: String, eventType: String) {
        Log.d("Event", "trackEvent: $eventName $eventType")
    }
}

}