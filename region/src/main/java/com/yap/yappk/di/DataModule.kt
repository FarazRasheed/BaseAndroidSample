package com.yap.yappk.di

import com.yap.networking.microservices.authentication.AuthApi
import com.yap.networking.microservices.authentication.AuthRepository
import com.yap.networking.microservices.messages.MessagesApi
import com.yap.networking.microservices.messages.MessagesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    @Singleton
    abstract fun provideAuthRepository(authRepository: AuthRepository): AuthApi

    @Binds
    @Singleton
    abstract fun provideMessagesRepository(messagesRepository: MessagesRepository): MessagesApi

}