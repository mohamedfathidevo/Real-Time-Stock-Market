package com.mohamedfathidev.realtimestockmarket.ui.details.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mohamedfathidev.realtimestockmarket.domain.usecase.GetRangeIntervalsUseCase
import com.mohamedfathidev.realtimestockmarket.domain.usecase.RangeInterval
import com.mohamedfathidev.realtimestockmarket.domain.usecase.SelectableRangeInterval
import com.mohamedfathidev.realtimestockmarket.domain.usecase.toRangeInterval
import com.mohamedfathidev.realtimestockmarket.domain.usecase.toSelectable
import com.mohamedfathidev.realtimestockmarket.ui.theme.RealTimeStockMarketTheme

@Composable
fun IntervalButtons(
    choices: List<SelectableRangeInterval>,
    onClick: (RangeInterval) -> Unit
) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        choices.map {
            if (it.isSelected) {
                Button(onClick = { onClick(it.toRangeInterval()) }) {
                    Text(it.name)
                }
            } else {
                TextButton(onClick = { onClick(it.toRangeInterval()) }) {
                    Text(it.name)
                }
            }
        }
    }
}

@Preview(
    showBackground = true, widthDp = 400, uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark Mode"
)
@Preview(showBackground = true, widthDp = 400, name = "Light Mode")
@Composable
fun IntervalButtons_Preview() {
    RealTimeStockMarketTheme {
        IntervalButtons(
            GetRangeIntervalsUseCase().invoke()
                .mapIndexed { index, item -> item.toSelectable(index == 3) }
        ) {}
    }
}
