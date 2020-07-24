package com.example.dinfo.Notifications

class NotificationObject(
    var head: String,
    var body: String,
    var dateon: String,
    var datefrom: String
) {
    companion object {
        fun fromString(st: String): NotificationObject = NotificationObject(
            st.split("- -")[0],
            st.split("- -")[1],
            st.split("- -")[2],
            st.split("- -")[3]
        )
    }

    override fun toString(): String {
        return "$head- -$body- -$dateon- -$datefrom"
    }
}