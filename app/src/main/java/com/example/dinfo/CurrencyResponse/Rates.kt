import com.example.converter3.ConverterRow
import com.google.gson.annotations.SerializedName

data class Rates(

    @SerializedName("CAD") val cAD: Double,
    @SerializedName("HKD") val hKD: Double,
    @SerializedName("ISK") val iSK: Double,
    @SerializedName("PHP") val pHP: Double,
    @SerializedName("DKK") val dKK: Double,
    @SerializedName("HUF") val hUF: Double,
    @SerializedName("CZK") val cZK: Double,
    @SerializedName("AUD") val aUD: Double,
    @SerializedName("RON") val rON: Double,
    @SerializedName("SEK") val sEK: Double,
    @SerializedName("IDR") val iDR: Double,
    @SerializedName("INR") val iNR: Double,
    @SerializedName("BRL") val bRL: Double,
    @SerializedName("RUB") val rUB: Double,
    @SerializedName("HRK") val hRK: Double,
    @SerializedName("JPY") val jPY: Double,
    @SerializedName("THB") val tHB: Double,
    @SerializedName("CHF") val cHF: Double,
    @SerializedName("SGD") val sGD: Double,
    @SerializedName("PLN") val pLN: Double,
    @SerializedName("BGN") val bGN: Double,
    @SerializedName("TRY") val tRY: Double,
    @SerializedName("CNY") val cNY: Double,
    @SerializedName("NOK") val nOK: Double,
    @SerializedName("NZD") val nZD: Double,
    @SerializedName("ZAR") val zAR: Double,
    @SerializedName("USD") val uSD: Double,
    @SerializedName("MXN") val mXN: Double,
    @SerializedName("ILS") val iLS: Double,
    @SerializedName("GBP") val gBP: Double,
    @SerializedName("KRW") val kRW: Double,
    @SerializedName("MYR") val mYR: Double
) {
    fun getCAD(): ConverterRow {
        return ConverterRow("CAD", cAD)
    }

    fun getHKD(): ConverterRow {
        return ConverterRow("HKD", hKD)
    }

    fun getISK(): ConverterRow {
        return ConverterRow("ISK", iSK)
    }

    fun getPHP(): ConverterRow {
        return ConverterRow("PHP", pHP)
    }

    fun getDKK(): ConverterRow {
        return ConverterRow("DKK", dKK)
    }

    fun getHUF(): ConverterRow {
        return ConverterRow("HUF", hUF)
    }

    fun getCZK(): ConverterRow {
        return ConverterRow("CZK", cZK)
    }

    fun getAUD(): ConverterRow {
        return ConverterRow("AUD", aUD)
    }

    fun getRON(): ConverterRow {
        return ConverterRow("RON", rON)
    }

    fun getSEK(): ConverterRow {
        return ConverterRow("SEK", sEK)
    }

    fun getIDR(): ConverterRow {
        return ConverterRow("IDR", iDR)
    }

    fun getINR(): ConverterRow {
        return ConverterRow("INR", iNR)
    }

    fun getBRL(): ConverterRow {
        return ConverterRow("BRL", bRL)
    }

    fun getRUB(): ConverterRow {
        return ConverterRow("RUB", rUB)
    }

    fun getHRK(): ConverterRow {
        return ConverterRow("HRK", hRK)
    }

    fun getJPY(): ConverterRow {
        return ConverterRow("JPY", jPY)
    }

    fun getTHB(): ConverterRow {
        return ConverterRow("THB", tHB)
    }

    fun getCHF(): ConverterRow {
        return ConverterRow("CHF", cHF)
    }

    fun getSGD(): ConverterRow {
        return ConverterRow("SGD", sGD)
    }

    fun getPLN(): ConverterRow {
        return ConverterRow("PLN", pLN)
    }

    fun getBGN(): ConverterRow {
        return ConverterRow("BGN", bGN)
    }

    fun getTRY(): ConverterRow {
        return ConverterRow("TRY", tRY)
    }

    fun getCNY(): ConverterRow {
        return ConverterRow("CNY", cNY)
    }

    fun getNOK(): ConverterRow {
        return ConverterRow("NOK", nOK)
    }

    fun getNZD(): ConverterRow {
        return ConverterRow("NZD", nZD)
    }

    fun getZAR(): ConverterRow {
        return ConverterRow("ZAR", zAR)
    }

    fun getUSD(): ConverterRow {
        return ConverterRow("USD", uSD)
    }

    fun getMXN(): ConverterRow {
        return ConverterRow("MXN", mXN)
    }

    fun getILS(): ConverterRow {
        return ConverterRow("ILS", iLS)
    }

    fun getGBP(): ConverterRow {
        return ConverterRow("GBP", gBP)
    }

    fun getKRW(): ConverterRow {
        return ConverterRow("KRW", kRW)
    }

    fun getMYR(): ConverterRow {
        return ConverterRow("MYR", mYR)
    }


    fun GetBase(): ArrayList<ConverterRow> { //ArrayList на случай изменения количества валют в Json ответе, чтобы можно было за несколько строк все обновить
        val Base =
            ArrayList<ConverterRow>() //можно было бы не делать этот класс, а обрабатывать Json ответ как строку, но я посчитал, что мне будет так удобнее
        Base.add(getCAD())
        Base.add(getHKD())
        Base.add(getISK())
        Base.add(getPHP())
        Base.add(getDKK())
        Base.add(getHUF())
        Base.add(getCZK())
        Base.add(getAUD())
        Base.add(getRON())
        Base.add(getSEK())
        Base.add(getIDR())
        Base.add(getINR())
        Base.add(getBRL())
        Base.add(getRUB())
        Base.add(getHRK())
        Base.add(getJPY())
        Base.add(getTHB())
        Base.add(getCHF())
        Base.add(getSGD())
        Base.add(getPLN())
        Base.add(getBGN())
        Base.add(getTRY())
        Base.add(getCNY())
        Base.add(getNOK())
        Base.add(getNZD())
        Base.add(getZAR())
        Base.add(getUSD())
        Base.add(getMXN())
        Base.add(getILS())
        Base.add(getGBP())
        Base.add(getKRW())
        Base.add(getMYR())
        Base.add(ConverterRow("EUR", 1.0))
        return Base
    }


}