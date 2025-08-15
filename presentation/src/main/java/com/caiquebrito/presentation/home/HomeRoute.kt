package com.caiquebrito.presentation.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.cora.card.presentation.model.UserAddressData
import kotlinx.serialization.Serializable

@Serializable
object HomeRoute

fun NavController.open() {
    navigate(CardOrderAddressRoute)
}

fun NavGraphBuilder.screenContent(
    openAnotherContent: () -> Unit,
) = composable<HomeRoute> {
    HomeScreen()
}

