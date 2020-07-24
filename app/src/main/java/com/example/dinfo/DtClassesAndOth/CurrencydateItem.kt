package com.example.dinfo.DtClassesAndOth

class CurrencydateItem(var frm: String, var to: String) {
    companion object {
        fun fromString(st: String): CurrencydateItem =
            CurrencydateItem(
                st.split("- -")[0],
                st.split("- -")[1]
            )
    }

    override fun toString(): String {
        return "$frm- -$to"
    }
}