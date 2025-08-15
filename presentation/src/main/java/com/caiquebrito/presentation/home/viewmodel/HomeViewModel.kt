package com.caiquebrito.presentation.home

import androidx.lifecycle.viewModelScope
import br.com.cora.analytics.tracker.EventTracker
import br.com.cora.analytics.tracker.ScreenAnalyticsEvent
import br.com.cora.analytics.tracker.lookedEvent
import br.com.cora.common.viewmodel.flow.ViewModel
import kotlinx.coroutines.launch

class HomeViewModel(
   private val eventTracker: EventTracker,
) : ViewModel<HomeState, HomeEffect>(HomeState()) {

   private val baseEvent = ScreenAnalyticsEvent("", "")

   init {
       eventTracker.trackEvent(baseEvent.lookedEvent())
   }
}

