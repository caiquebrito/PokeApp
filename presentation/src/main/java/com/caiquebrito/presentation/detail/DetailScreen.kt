package com.caiquebrito.presentation.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.cora.common.extensions.collectAsEffect
import org.koin.androidx.compose.koinViewModel

@Composable
fun DetailScreen(
    viewModel: DetailViewModel = koinViewModel(),
    openNewScreen: () -> Unit,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    viewModel.effect.collectAsEffect {
        when (it) {
            else -> openNewScreen()
        }
    }
    DetailContent()
    LaunchedEffect(key1 = Unit) {
        viewModel.onCreate()
    }
}

@Preview
@Composable
fun DetailScreenPreview() {
    ArcoPreview {
        DetailScreen()
    }
}

