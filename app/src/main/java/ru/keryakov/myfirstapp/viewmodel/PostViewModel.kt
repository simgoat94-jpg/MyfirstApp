package ru.keryakov.myfirstapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ru.keryakov.myfirstapp.dto.Post
import ru.keryakov.myfirstapp.repository.PostRepository
import ru.keryakov.myfirstapp.repository.PostRepositoryInMemoryImpl

class PostViewModel {
    private val repository: PostRepository = PostRepositoryInMemoryImpl()

    val data: LiveData<Post> = repository.get()

    fun like() = repository.like()
    fun share() = repository.share()
    fun increaseViews() = repository.increaseViews()

}