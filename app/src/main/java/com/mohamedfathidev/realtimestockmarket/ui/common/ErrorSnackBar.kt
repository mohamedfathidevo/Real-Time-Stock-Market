package com.mohamedfathidev.realtimestockmarket.ui.common

import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.SnackbarResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

fun CoroutineScope.showErrorSnackBar(
    snackBarHostState: SnackbarHostState,
    onClick: () -> Unit
) {
    launch {
        snackBarHostState.currentSnackbarData?.dismiss()

        val result = snackBarHostState.showSnackbar(
            message = "Something went wrong",
            actionLabel = "Try Again!",
            duration = SnackbarDuration.Indefinite
        )

        when (result) {
            SnackbarResult.Dismissed -> {}
            SnackbarResult.ActionPerformed -> onClick()
        }
    }
}