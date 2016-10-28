package com.lostincontext.condition

import com.google.android.gms.maps.model.LatLng
import com.lostincontext.commons.BasePresenter
import com.lostincontext.commons.BaseView
import com.lostincontext.commons.list.Section
import com.lostincontext.condition.pick.GridBottomSheetItem
import com.lostincontext.condition.pick.PickerDialogCallback
import com.lostincontext.condition.pick.PlusButtonCallback
import com.lostincontext.data.rulesV2.AtomicCondition
import com.lostincontext.rulecreate.AtomicConditionItem
import com.lostincontext.ruledetails.items.FenceItemCallback


interface ConditionContract {

    interface View : BaseView<Presenter> {

        fun displayFenceChoice()
        fun checkPermissionsAndShowLocationPicker(name: String, item: GridBottomSheetItem)
        fun add(atomicCondition: AtomicCondition, isFirst: Boolean)
    }

    interface Presenter : BasePresenter,
                          PlusButtonCallback,
                          PickerDialogCallback,
                          FenceItemCallback,
                          AtomicConditionItem.Callback {

        fun onMenuItemClick(itemId: Int): Boolean
        fun provideFenceChoices(): List<Section<*>>
        fun onPlacePicked(placeName: String, item: GridBottomSheetItem, latLng: LatLng)
    }
}
