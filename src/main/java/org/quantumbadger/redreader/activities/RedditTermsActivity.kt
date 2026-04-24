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

package org.quantumbadger.redreader.activities

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import org.quantumbadger.redreader.R
import org.quantumbadger.redreader.common.LinkHandler
import org.quantumbadger.redreader.common.PrefsUtility
import org.quantumbadger.redreader.common.UriString

class RedditTermsActivity : ViewsBaseActivity() {

	companion object {

		private const val extraLaunchMain = "launch_main"

		@JvmStatic
		fun launch(activity: AppCompatActivity, launchMainOnClose: Boolean) {
			val intent = Intent(activity, RedditTermsActivity::class.java)
			intent.putExtra(extraLaunchMain, launchMainOnClose)
			activity.startActivity(intent)
		}
	}

	override fun baseActivityIsActionBarBackEnabled() = false

	override fun onCreate(savedInstanceState: Bundle?) {

		PrefsUtility.applySettingsTheme(this)

		super.onCreate(savedInstanceState)

		window.navigationBarColor = Color.rgb(0x55, 0x55, 0x55)

		val launchMainOnClose = intent.getBooleanExtra(extraLaunchMain, false)

		fun onDone() {
			if (launchMainOnClose) {
				startActivity(Intent(this, MainActivity::class.java))
			}
			finish()
		}

		val composeView = androidx.compose.ui.platform.ComposeView(this).apply {
			setContent {
				org.quantumbadger.redreader.shared.RedditTermsScreen(
					title = getString(R.string.reddit_terms_title),
					message = getString(R.string.reddit_terms_message),
					viewButtonText = getString(R.string.reddit_terms_view_button),
					declineButtonText = getString(R.string.terms_decline),
					acceptButtonText = getString(R.string.terms_accept),
					onViewTermsClicked = {
						LinkHandler.onLinkClicked(
							this@RedditTermsActivity,
							UriString("https://www.redditinc.com/policies/user-agreement-april-18-2023")
						)
					},
					onDeclineClicked = {
						PrefsUtility.declineRedditUserAgreement()
						onDone()
					},
					onAcceptClicked = {
						PrefsUtility.acceptRedditUserAgreement()
						onDone()
					}
				)
			}
		}

		setBaseActivityListing(composeView)
	}
}
