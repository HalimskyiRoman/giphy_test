package com.opinc.giphy_wwl.di

import com.opinc.giphy_wwl.data.repository.GiphyRepositoryImpl
import com.opinc.giphy_wwl.domain.repository.GiphyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideGiphyRepository(impl: GiphyRepositoryImpl): GiphyRepository


}