package park.sangeun.testprojects.domain.payment.model

data class PayRequest (
    val amount: Int,
    val merchantId: Long,
    val merchantTid: String,
    val pMethodId: Long,
    val payInfo: Map<String, String>
)