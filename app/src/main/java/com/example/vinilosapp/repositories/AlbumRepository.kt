package com.example.vinilosapp.repositories

import android.app.Application
import com.android.volley.VolleyError
import com.example.vinilosapp.models.Album
import com.example.vinilosapp.network.NetworkServiceAdapter

class AlbumRepository(val application: Application) {
    fun refreshData(callback: (List<Album>) -> Unit, onError: (VolleyError) -> Unit) {
        //Determinar la fuente de datos que se va a utilizar. Si es necesario consultar la red, ejecutar el siguiente código
        NetworkServiceAdapter.getInstance(application).getAlbums(
            {
                //Guardar los albumes de la variable it en un almacén de datos local para uso futuro
                callback(it)
            },
            onError
        )
    }

    fun getAlbum(
        albumId: Int,
        name: String,
        cover: String,
        releaseDate: String,
        description: String,
        genre: String,
        onError:(Throwable?) -> Unit,
        onSuccess: (Album?) -> Unit
    ) {
        NetworkServiceAdapter.getAlbum(albumId, onError, onSuccess)
    }

    fun addAlbum(
        userId: String,
        title: String,
        description: String,
        timestamp: Timestamp,
        color: Int = 0,
        onComplete: (Boolean) -> Unit,
    ) {
        NetworkServiceAdapter.addAlbum(userId, title, description, timestamp, color, onComplete)
    }
}