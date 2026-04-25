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

package org.quantumbadger.redreader.compose.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import org.quantumbadger.redreader.R
import org.quantumbadger.redreader.common.UriString
import org.quantumbadger.redreader.compose.ctx.Dest
import org.quantumbadger.redreader.compose.ctx.LocalLauncher
import org.quantumbadger.redreader.compose.ctx.RRComposeContextTest
import org.quantumbadger.redreader.shared.theme.ComposeThemeLinkButton
import org.quantumbadger.redreader.compose.theme.LocalComposeTheme
import org.quantumbadger.redreader.compose.theme.combinedClickableWithHaptics

@Composable
fun RRLinkButton(
	title: String,
	link: UriString,
	theme: ComposeThemeLinkButton
) {
	val launch = LocalLauncher.current

	org.quantumbadger.redreader.shared.ui.RRLinkButton(
		title = title,
		subtitle = link.value,
		linkIconPainter = painterResource(id = R.drawable.ic_action_link_dark),
		arrowIconPainter = painterResource(id = R.drawable.chevron_right_dark),
		theme = theme,
		modifier = Modifier.combinedClickableWithHaptics(
			role = Role.Button,
			onClick = { launch(Dest.Link(link)) },
			onLongClick = { launch(Dest.LinkLongClick(link)) }
		)
	)
}

@Composable
@Preview
private fun PreviewRRLinkButton() {
	RRComposeContextTest {

		val theme = LocalComposeTheme.current

		RRLinkButton(
			title = "Test Button",
			link = UriString("https://redreader.org"),
			theme = theme.linkButton
		)
	}
}
