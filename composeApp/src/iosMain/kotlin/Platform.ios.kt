import data.local.CurrencyDatabase
import data.local.getDatabaseBuilder
import org.koin.dsl.module
import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): Platform = IOSPlatform()

actual fun platformModule() = module {
    single<CurrencyDatabase> { getDatabaseBuilder() }
}