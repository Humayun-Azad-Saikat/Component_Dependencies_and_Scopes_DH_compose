package com.example.component_dependencis_and_scopes_dh_compose.modules


import com.example.component_dependencis_and_scopes_dh_compose.SQLrepository
import com.example.component_dependencis_and_scopes_dh_compose.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.migration.DisableInstallInCheck

@DisableInstallInCheck
@Module
class UserRepositoryModule {

//    @Provides
//    fun getFirebaseRepository(): UserRepository {
//        return FirebaseRepository()
//    }

    @Provides
    fun getSQLrepository(sqLrepository: SQLrepository): UserRepository {
        return sqLrepository
    }
}