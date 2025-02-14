import com.google.gson.annotations.SerializedName

data class MainNewsResponse(

    @SerializedName("status") val status: String,
    @SerializedName("totalResults") val totalResults: Int,
    @SerializedName("articles") val articles: List<Articles>
)