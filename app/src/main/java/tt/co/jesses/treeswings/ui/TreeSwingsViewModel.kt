package tt.co.jesses.treeswings.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import tt.co.jesses.treeswings.data.model.TreeSwing
import tt.co.jesses.treeswings.data.repository.TreeSwingsRepository
import tt.co.jesses.treeswings.data.repository.TreeSwingsRepositoryImpl

data class TreeSwingsUiState(
    val swings: List<TreeSwing> = emptyList()
)

class TreeSwingsViewModel(
    private val repository: TreeSwingsRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(TreeSwingsUiState())
    val uiState: StateFlow<TreeSwingsUiState> = _uiState.asStateFlow()

    init {
        loadSwings()
    }

    private fun loadSwings() {
        viewModelScope.launch {
            val swings = repository.getSwings()
            _uiState.value = TreeSwingsUiState(swings = swings)
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val repository = TreeSwingsRepositoryImpl()
                TreeSwingsViewModel(repository)
            }
        }
    }
}
