import android.os.Build
import data.local.CurrencyDatabase
import data.local.getDatabaseBuilder
import org.koin.dsl.module

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()
actual fun platformModule() = module {
    single<CurrencyDatabase> { getDatabaseBuilder(get()) }
}