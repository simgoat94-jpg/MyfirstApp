package ru.keryakov.myfirstapp.repository

import androidx.lifecycle.LiveData
import ru.keryakov.myfirstapp.dto.Post

interface PostRepository {
    fun get(): LiveData<Post>
    fun like()
    fun share()
    fun increaseViews()
}