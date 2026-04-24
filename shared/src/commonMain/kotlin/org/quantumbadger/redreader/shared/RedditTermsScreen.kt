package org.quantumbadger.redreader.shared

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RedditTermsScreen(
    title: String,
    message: String,
    viewButtonText: String,
    declineButtonText: String,
    acceptButtonText: String,
    onViewTermsClicked: () -> Unit,
    onDeclineClicked: () -> Unit,
    onAcceptClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(start = 24.dp, end = 24.dp, top = 24.dp)
        )

        Text(
            text = message,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(start = 24.dp, end = 24.dp, top = 14.dp)
        )

        TextButton(
            onClick = onViewTermsClicked,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, top = 14.dp)
        ) {
            Text(
                text = viewButtonText,
                fontSize = 18.sp,
                color = androidx.compose.ui.graphics.Color(0xFF1188DD)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, top = 14.dp, bottom = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = onDeclineClicked) {
                Text(text = declineButtonText)
            }
            Button(onClick = onAcceptClicked) {
                Text(text = acceptButtonText)
            }
        }
    }
}
