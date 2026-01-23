package org.michaelbel.plurals

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PluralsComposable() {
    var count by remember { mutableIntStateOf(0) }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = pluralStringResource(R.plurals.days_count, count, count),
            modifier = Modifier.align(Alignment.Center),
            fontSize = 64.sp
        )

        Row(
            modifier = Modifier
                .padding(bottom = 64.dp)
                .align(Alignment.BottomCenter)
        ) {
            FilledTonalIconButton(
                onClick = { count-- }
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_remove_24),
                    contentDescription = "Decrease"
                )
            }

            FilledTonalIconButton(
                onClick = { count++ }
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_add_24),
                    contentDescription = "Increase"
                )
            }
        }
    }
}
