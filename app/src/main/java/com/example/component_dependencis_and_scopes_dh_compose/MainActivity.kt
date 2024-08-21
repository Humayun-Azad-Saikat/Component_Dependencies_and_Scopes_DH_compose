package com.example.component_dependencis_and_scopes_dh_compose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.component_dependencis_and_scopes_dh_compose.ui.theme.Component_dependencis_and_Scopes_DH_composeTheme
import com.example.singleton_annotation_and_scopes_compose.DaggerConsumerComponent
import javax.inject.Inject


/**
 * there are two types of scopes: application level and activity level objects in this app
 *we made an interface named analytics service then we defined a module for this
 * then we annotated this with singleton annotation (generally we use singletion annotation with application level
 * singletons) then we created another component (AppComponent) that will be on application level
 * we created a userapplication class there we implemented the Appcomponent
 * to link the application level and avtivity level modules we inmplemented the application level component
 * module(AnalyticsModule) in the activity level component annotation the we do some prosidure
 */




class MainActivity : ComponentActivity() {

    @Inject
    lateinit var userResistaionService: UserResistaionService


   lateinit var emailService: EmailService
   lateinit var emailService1: EmailService


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Component_dependencis_and_Scopes_DH_composeTheme {
               Surface(
                   modifier = Modifier.fillMaxSize(),
                   color = Color.White
               ) {

                   val appComponent = (application as UserApplication).appComponent
                   val component = DaggerConsumerComponent.factory().create(3,appComponent)


                   emailService = component.getEmailservice()
                   emailService1 = component.getEmailservice()

                  Log.d("emailServiceclasscode", "${emailService}")
                  Log.d("emailServiceclasscode1", "${emailService1}")
                  component.injectMainAC(this)
                  userResistaionService.resisterUser("","")





               }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}