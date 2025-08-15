package com.caiquebrito.presentation.home

import br.com.cora.common.viewmodel.flow.UIState

data class HomeState(
   val isLoading: Boolean = false,
) : UIState
