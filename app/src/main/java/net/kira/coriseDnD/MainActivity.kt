package net.kira.coriseDnD

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import net.kira.coriseDnD.di.appModule
import net.kira.coriseDnD.presentation.screen.CharacterListScreen
import net.kira.coriseDnD.ui.theme.CoriseDnDTheme
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            CoriseDnDTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CharacterListScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}