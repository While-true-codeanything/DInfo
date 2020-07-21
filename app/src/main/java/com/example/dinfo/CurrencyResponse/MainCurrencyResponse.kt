import com.google.gson.annotations.SerializedName


data class MainCurrencyResponse(

    @SerializedName("rates") val rates: Rates,
    @SerializedName("base") val base: String,
    @SerializedName("date") val date: String
)