package io.example.retrofit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _post = MutableLiveData<MyPost>()
    val post: LiveData<MyPost>
        get() = _post

    init {
        fetchPost()
    }

    fun fetchPost() {
        viewModelScope.launch {
            val post: MyPost = RetrofitInstance.api.fetchPost()
            _post.value = post
        }
    }
}
