package org.quantumbadger.redreader.shared.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import org.quantumbadger.redreader.shared.theme.ComposeThemeLinkButton

@Composable
fun RRLinkButton(
    title: String,
    subtitle: String,
    linkIconPainter: Painter,
    arrowIconPainter: Painter,
    theme: ComposeThemeLinkButton,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .semantics(mergeDescendants = true) {}
            .border(theme.borderThickness, theme.borderColor, theme.shape)
            .clip(theme.shape)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(20.dp),
            painter = linkIconPainter,
            contentDescription = null,
            tint = theme.iconColor
        )
        Spacer(Modifier.width(12.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            theme.title.StyledText(title)
            Spacer(Modifier.height(1.dp))
            theme.subtitle.StyledText(subtitle)
        }
        Spacer(Modifier.width(12.dp))
        Icon(
            modifier = Modifier.size(20.dp),
            painter = arrowIconPainter,
            contentDescription = null,
            tint = theme.iconColor
        )
    }
}
