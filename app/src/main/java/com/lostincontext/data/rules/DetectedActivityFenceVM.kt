package com.lostincontext.data.rules


import com.google.android.gms.awareness.fence.AwarenessFence

data class DetectedActivityFenceVM(val type: Type,
                                   val state: State) : FenceVM {

    enum class Type {
        RUNNING,
        WALKING,
        IN_VEHICLE,
        ON_BICYCLE,
        ON_FOOT
    }

    enum class State {
        STARTING,
        DURING,
        STOPPING
    }

    override fun build(builder: FenceBuilder): AwarenessFence = builder.detectedActivity(this)

    override fun giveIcon(iconGiver: FenceIconGiver,
                          icons: MutableList<Int>) = iconGiver.detectedActivity(this, icons)

    override fun name(fenceNamer: FenceNamer) = fenceNamer.detectedActivity(this)

}
