package com.example.vinilosapp.ui.Screens

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vinilosapp.models.Album
import com.example.vinilosapp.network.NetworkServiceAdapter
import com.example.vinilosapp.repositories.AlbumRepository
import com.example.vinilosapp.ui.theme.VinilosAppTheme


@SuppressLint("RememberReturnType")
@Composable
fun AlbumListScreen(context: Context) {
    val albumRepository = remember { AlbumRepository(context.applicationContext as Application) }
    val albums = remember { mutableStateOf<List<Album>>(emptyList()) }
    val selectedAlbum = remember { mutableStateOf<Album?>(null) }

    LaunchedEffect(Unit) {
        val fetchedAlbums = albumRepository.refreshData()
        albums.value = fetchedAlbums
    }

    LazyColumn {
        items(albums.value) { album ->
            AlbumItem(album) {
                selectedAlbum.value = album
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun AlbumListPreview() {
    val albums = listOf(
        // Create some sample Album objects
        Album(1, "Artist 1"),
        Album(2, "Artist 2")
    )
    LazyColumn {
        items(albums) { album ->
            AlbumItem(album) {
                // Simulate selection for preview (optional)
            }
        }
    }
}

@Composable
fun AlbumItem(album: Album, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Text(album.name.toString())
        Spacer(modifier = Modifier.width(16.dp))
        Text("")
    }
}