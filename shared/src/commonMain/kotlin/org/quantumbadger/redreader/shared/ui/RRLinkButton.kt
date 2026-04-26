/*******************************************************************************
 * This file is part of RedReader.
 *
 * RedReader is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * RedReader is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with RedReader.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/

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
import androidx.compose.ui.unit.dp
import org.quantumbadger.redreader.shared.theme.ComposeThemeLinkButton
import org.quantumbadger.redreader.shared.ui.StyledText

@Composable
fun RRLinkButton(
	modifier: Modifier = Modifier,
	clickableModifier: Modifier = Modifier,
	title: String,
	subtitle: String,
	linkIconPainter: Painter,
	arrowIconPainter: Painter,
	theme: ComposeThemeLinkButton
) {
	Row(
		modifier = modifier
			.fillMaxWidth()
			.border(theme.borderThickness, theme.borderColor, theme.shape)
			.clip(theme.shape)
			.then(clickableModifier)
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
