package com.example.vinilosapp.repositories

import android.app.Application
import com.example.vinilosapp.models.Album
import com.example.vinilosapp.network.NetworkServiceAdapter
import org.json.JSONException
import org.json.JSONObject

class AlbumRepository(val application: Application) {
    suspend fun refreshData(): List<Album> {
        //Determinar la fuente de datos que se va a utilizar. Si es necesario consultar la red, ejecutar el siguiente código
        return NetworkServiceAdapter.getInstance(application).getAlbums()
    }

    suspend fun getAlbum(albumId: Int): Album {
        return NetworkServiceAdapter.getInstance(application).getAlbum(albumId)
    }

    suspend fun addAlbum(
        name: String,
        cover: String,
        releaseDate: String,
        description: String,
        genre: String
    ): JSONObject {
        try {
            val albumObject = JSONObject().apply {
                put("name", name)
                put("cover", cover)
                put("releaseDate", releaseDate)
                put("description", description)
                put("genre", genre)
            }

            return NetworkServiceAdapter.getInstance(application).postAlbum(albumObject)
        } catch (e: JSONException) {
            throw RuntimeException("Error creating album JSON object", e)
        }
    }
}