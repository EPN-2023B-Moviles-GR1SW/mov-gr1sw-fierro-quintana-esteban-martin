package com.example.app1_gr1sw

import com.firebase.ui.auth.data.model.CountryInfo

class ICities(
    public var name:String?,
    public var state :String?,
    public var country :String?,
    public var capital :Boolean?,
    public var population:Long?,
    public var regions: List<String>?,
) {
    override fun toString(): String {
        return "${name} - ${country}"
    }


}