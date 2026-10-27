package net.kira.coriseDnD.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.kira.coriseDnD.presentation.viewmodel.CharacterListViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun CharacterListScreen(modifier: Modifier = Modifier, viewModel: CharacterListViewModel = koinViewModel()) {
    val characters by viewModel.characters.collectAsState()

    if (characters.isEmpty()) {
        Text("У вас еще нет персонажей!", modifier)
    }
    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(characters) { character ->
            Card(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text(character.name, style = MaterialTheme.typography.titleMedium)
                    Text("Уровень ${character.level}", style = MaterialTheme.typography.bodySmall)
                }
            }
        }
    }
}