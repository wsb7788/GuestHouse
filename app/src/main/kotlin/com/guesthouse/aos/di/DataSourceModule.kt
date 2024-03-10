package com.guesthouse.aos.di

import com.guesthouse.datasource.LoginDataSource
import com.guesthouse.network.LoginDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Binds
    @Singleton
    fun provideLoginDataSource(loginDataSourceImpl: LoginDataSourceImpl): LoginDataSource
}