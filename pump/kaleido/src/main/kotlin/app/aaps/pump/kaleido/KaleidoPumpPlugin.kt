package app.aaps.pump.kaleido

import app.aaps.core.data.plugin.PluginType
import app.aaps.core.data.pump.defs.ManufacturerType
import app.aaps.core.data.pump.defs.PumpDescription
import app.aaps.core.data.pump.defs.PumpType
import app.aaps.core.interfaces.logging.AAPSLogger
import app.aaps.core.interfaces.plugin.PluginDescription
import app.aaps.core.interfaces.profile.Profile
import app.aaps.core.interfaces.pump.DetailedBolusInfo
import app.aaps.core.interfaces.pump.Pump
import app.aaps.core.interfaces.pump.PumpEnactResult
import app.aaps.core.interfaces.pump.PumpPluginBase
import app.aaps.core.interfaces.pump.PumpSync
import app.aaps.core.interfaces.queue.CommandQueue
import app.aaps.core.interfaces.resources.ResourceHelper
import app.aaps.core.keys.interfaces.Preferences
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

/**
 * Scaffold for a future Kaleido pump driver.
 *
 * SAFETY: The Kaleido communication protocol is not publicly documented, so this class intentionally
 * implements NO communication. It reports itself as not initialized and not connected, and every command
 * that would change insulin delivery returns a failed result. It must never deliver insulin until a real,
 * tested driver replaces these methods.
 */
@Singleton
class KaleidoPumpPlugin @Inject constructor(
    aapsLogger: AAPSLogger,
    rh: ResourceHelper,
    preferences: Preferences,
    commandQueue: CommandQueue,
    private val pumpEnactResultProvider: Provider<PumpEnactResult>
) : PumpPluginBase(
    pluginDescription = PluginDescription()
        .mainType(PluginType.PUMP)
        .pluginName(R.string.kaleido_pump)
        .shortName(R.string.kaleido_shortname)
        .description(R.string.description_pump_kaleido)
        .enableByDefault(false)
        .visibleByDefault(false),
    aapsLogger = aapsLogger,
    rh = rh,
    preferences = preferences,
    commandQueue = commandQueue
), Pump {

    // No capabilities are declared: the pump cannot bolus, set temp basal or change profiles.
    override val pumpDescription = PumpDescription()

    override var lastDataTime: Long = 0
    override val lastBolusTime: Long? = null
    override val lastBolusAmount: Double? = null
    override val baseBasalRate: Double = 0.0
    override val reservoirLevel: Double = 0.0
    override val batteryLevel: Int? = null
    override val isFakingTempsByExtendedBoluses: Boolean = false

    override fun isInitialized(): Boolean = false
    override fun isSuspended(): Boolean = false
    override fun isBusy(): Boolean = false
    override fun isConnected(): Boolean = false
    override fun isConnecting(): Boolean = false
    override fun isHandshakeInProgress(): Boolean = false

    override fun connect(reason: String) {}
    override fun disconnect(reason: String) {}
    override fun stopConnecting() {}
    override fun getPumpStatus(reason: String) {}

    override fun setNewBasalProfile(profile: Profile): PumpEnactResult = notImplemented()
    override fun isThisProfileSet(profile: Profile): Boolean = false

    override fun deliverTreatment(detailedBolusInfo: DetailedBolusInfo): PumpEnactResult = notImplemented()
    override fun stopBolusDelivering() {}

    override fun setTempBasalAbsolute(
        absoluteRate: Double,
        durationInMinutes: Int,
        profile: Profile,
        enforceNew: Boolean,
        tbrType: PumpSync.TemporaryBasalType
    ): PumpEnactResult = notImplemented()

    override fun setTempBasalPercent(
        percent: Int,
        durationInMinutes: Int,
        profile: Profile,
        enforceNew: Boolean,
        tbrType: PumpSync.TemporaryBasalType
    ): PumpEnactResult = notImplemented()

    override fun cancelTempBasal(enforceNew: Boolean): PumpEnactResult = notImplemented()
    override fun setExtendedBolus(insulin: Double, durationInMinutes: Int): PumpEnactResult = notImplemented()
    override fun cancelExtendedBolus(): PumpEnactResult = notImplemented()

    override fun manufacturer(): ManufacturerType = ManufacturerType.AAPS
    override fun model(): PumpType = PumpType.GENERIC_AAPS
    override fun serialNumber(): String = ""

    override fun loadTDDs(): PumpEnactResult = notImplemented()
    override fun canHandleDST(): Boolean = false

    private fun notImplemented(): PumpEnactResult =
        pumpEnactResultProvider.get()
            .success(false)
            .enacted(false)
            .comment(rh.gs(R.string.kaleido_not_implemented))
}
