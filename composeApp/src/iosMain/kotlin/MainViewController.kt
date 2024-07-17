import androidx.compose.ui.window.ComposeUIViewController
import org.coinz.App
import org.coinz.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = { initKoin() }
) { App() }