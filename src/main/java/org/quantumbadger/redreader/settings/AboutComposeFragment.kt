package org.quantumbadger.redreader.settings

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import org.quantumbadger.redreader.RedReader
import org.quantumbadger.redreader.activities.ChangelogActivity
import org.quantumbadger.redreader.activities.HtmlViewActivity
import org.quantumbadger.redreader.shared.AboutScreen

class AboutComposeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val versionName = RedReader.getInstance(requireContext()).packageInfo.versionName ?: "Unknown"
                AboutScreen(
                    versionName = versionName,
                    onChangelogClick = {
                        val intent = Intent(requireContext(), ChangelogActivity::class.java)
                        requireContext().startActivity(intent)
                    },
                    onLicenseClick = {
                        HtmlViewActivity.showAsset(requireContext(), "license.html")
                    }
                )
            }
        }
    }
}
