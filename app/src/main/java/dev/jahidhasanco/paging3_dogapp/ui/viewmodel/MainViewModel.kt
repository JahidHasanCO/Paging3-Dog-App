package dev.jahidhasanco.paging3_dogapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.jahidhasanco.paging3_dogapp.data.model.Dogs
import dev.jahidhasanco.paging3_dogapp.data.repo.DogsPageSource
import dev.jahidhasanco.paging3_dogapp.netwok.ApiService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


@HiltViewModel
class MainViewModel
@Inject constructor(private val apiService: ApiService) : ViewModel()
{
    val getAllDogs: Flow<PagingData<Dogs>> = Pager(config = PagingConfig(20,enablePlaceholders = false)){
        DogsPageSource(apiService)
    }.flow.cachedIn(viewModelScope)


}