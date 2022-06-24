package com.yap.yappk.di

import com.yap.networking.apiclient.base.RetroNetwork
import com.yap.networking.microservices.authentication.AuthRetroService
import com.yap.networking.microservices.messages.MessagesRetroService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class NetworkingModule {

    @Provides
    fun provideAuthService(retroNetwork: RetroNetwork): AuthRetroService {
        return retroNetwork.createService(AuthRetroService::class.java)
    }

    @Provides
    fun provideMessagesService(retroNetwork: RetroNetwork): MessagesRetroService {
        return retroNetwork.createService(MessagesRetroService::class.java)
    }

}