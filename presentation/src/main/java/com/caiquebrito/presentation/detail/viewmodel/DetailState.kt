package com.caiquebrito.presentation.detail

import br.com.cora.common.viewmodel.flow.UIState

data class DetailState(
    val isLoading: Boolean = false,
) : UIState
