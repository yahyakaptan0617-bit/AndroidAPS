package app.aaps.plugins.source

import app.aaps.core.data.plugin.PluginType
import app.aaps.core.interfaces.logging.AAPSLogger
import app.aaps.core.interfaces.plugin.PluginDescription
import app.aaps.core.interfaces.resources.ResourceHelper
import app.aaps.core.interfaces.source.BgSource
import app.aaps.core.keys.interfaces.Preferences
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Scaffold for a future Accu-Chek SmartGuide glucose source.
 *
 * SAFETY: This class intentionally reads NO data and writes NO glucose values. It exists only as a
 * placeholder so the source can be wired in once a real, tested implementation is available.
 * It is hidden and disabled by default.
 */
@Singleton
class AccuChekSmartGuidePlugin @Inject constructor(
    rh: ResourceHelper,
    aapsLogger: AAPSLogger,
    preferences: Preferences
) : AbstractBgSourcePlugin(
    pluginDescription = PluginDescription()
        .mainType(PluginType.BGSOURCE)
        .pluginName(R.string.accu_chek_smartguide)
        .shortName(R.string.accu_chek_smartguide_short)
        .preferencesVisibleInSimpleMode(false)
        .description(R.string.description_source_accu_chek_smartguide)
        .enableByDefault(false)
        .visibleByDefault(false),
    ownPreferences = emptyList(),
    aapsLogger, rh, preferences
), BgSource
