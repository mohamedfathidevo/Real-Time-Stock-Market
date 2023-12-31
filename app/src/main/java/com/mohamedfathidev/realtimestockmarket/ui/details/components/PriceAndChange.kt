package com.mohamedfathidev.realtimestockmarket.ui.details.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mohamedfathidev.realtimestockmarket.ui.home.screen.DeltaIndicator
import com.mohamedfathidev.realtimestockmarket.ui.home.screen.toColor
import com.mohamedfathidev.realtimestockmarket.ui.theme.RealTimeStockMarketTheme

@Composable
fun PriceAndChange(
    percentageChange: String,
    lastSalePrice: String,
    deltaIndicator: DeltaIndicator
) {
    Column {
        Text(
            percentageChange,
            Modifier
                .padding(top = 24.dp)
                .fillMaxWidth(),
            style = MaterialTheme.typography.body2,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = deltaIndicator.toColor()
        )
        Text(
            lastSalePrice,
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .padding(bottom = 24.dp)
                .fillMaxWidth(),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true, widthDp = 400, name = "Down")
@Composable
private fun PriceAndChange_PreviewDown() {
    RealTimeStockMarketTheme {
        PriceAndChange("-0.56%", "$125.67", DeltaIndicator.Down)
    }
}

@Preview(showBackground = true, widthDp = 400, name = "Up")
@Composable
private fun PriceAndChange_PreviewUp() {
    RealTimeStockMarketTheme {
        PriceAndChange("0.56%", "$125.67", DeltaIndicator.Up)
    }
}

@Preview(showBackground = true, widthDp = 400, name = "No Change")
@Composable
private fun PriceAndChange_PreviewNoChange() {
    RealTimeStockMarketTheme {
        PriceAndChange("0.00%", "$125.67", DeltaIndicator.NoChange)
    }
}
