package net.kira.coriseDnD.di

import androidx.room.Room
import net.kira.coriseDnD.data.local.AppDatabase
import net.kira.coriseDnD.data.repository.CharacterRepositoryImpl
import net.kira.coriseDnD.data.repository.GameDataRepositoryImpl
import net.kira.coriseDnD.data.repository.NoteRepositoryImpl
import net.kira.coriseDnD.domain.model.AttributeCatalog
import net.kira.coriseDnD.domain.repository.CharacterRepository
import net.kira.coriseDnD.domain.repository.GameDataRepository
import net.kira.coriseDnD.domain.repository.NoteRepository
import net.kira.coriseDnD.domain.usecase.CharacterBuilderUseCase
import net.kira.coriseDnD.domain.usecase.LevelUpUseCase
import net.kira.coriseDnD.domain.usecase.StatCalculatorUseCase
import net.kira.coriseDnD.presentation.viewmodel.CharacterListViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module


val appModule = module {

    //Database, DAO
    single {
        Room.databaseBuilder<AppDatabase>(androidContext(), "corisednd.db")
            .build()
    }
    single { get<AppDatabase>().characterDao() }
    single { get<AppDatabase>().gameDataDao() }
    single { get<AppDatabase>().noteDao() }

    //Repositories
    single<GameDataRepository> { GameDataRepositoryImpl(get()) }
    single<CharacterRepository> { CharacterRepositoryImpl(get(), get()) }
    single<NoteRepository> { NoteRepositoryImpl(get()) }

    //Domain
    single { AttributeCatalog(get()) }

    //Use case
    single { StatCalculatorUseCase() }
    single { CharacterBuilderUseCase(get()) }
    single { LevelUpUseCase(get(), get()) }

    //ViewModel
    viewModel { CharacterListViewModel(get()) }
}
