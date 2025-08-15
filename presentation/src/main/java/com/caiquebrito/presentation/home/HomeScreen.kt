package com.caiquebrito.presentation.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.cora.common.extensions.collectAsEffect
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel(),
    openNewScreen: () -> Unit,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    viewModel.effect.collectAsEffect {
        when (it) {
            else -> openNewScreen()
        }
    }
    HomeContent()
    LaunchedEffect(key1 = Unit) {
        viewModel.onCreate()
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    ArcoPreview {
        HomeScreen()
    }
}

