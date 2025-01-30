package com.opinc.giphy_wwl.presentation.activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.opinc.giphy_wwl.domain.data.GiphyModel
import com.opinc.giphy_wwl.domain.repository.GiphyRepository
import com.opinc.giphy_wwl.domain.utils.BaseResult.Success
import com.opinc.giphy_wwl.domain.utils.BaseResult.Error
import com.opinc.giphy_wwl.presentation.activity.MainActivityViewModel.ScreenState.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val giphyRepository: GiphyRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<ScreenState>(Loading)
    val uiState = _uiState.asStateFlow()

    init {
        getInitialData()
    }

    private fun getInitialData() {
        viewModelScope.launch {
            giphyRepository.getData().collectLatest {
                when (it) {
                    is Success -> {
                        _uiState.emit(
                            ScreenState.Success(
                                it.data
                            )
                        )
                    }

                    is Error -> _uiState.emit(
                        ScreenState.Error
                    )

                }

            }
        }
    }

    sealed interface ScreenState {
        data object Loading : ScreenState
        data class Success(val data: GiphyModel) : ScreenState
        object Error : ScreenState
    }
}