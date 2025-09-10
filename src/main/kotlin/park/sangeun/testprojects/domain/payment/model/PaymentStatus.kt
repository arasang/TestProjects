package park.sangeun.testprojects.domain.payment.model

enum class PaymentStatus(val state: Int) {
    REGISTER(10),
    PROGRESS(50),
    SUCCESS(70),
    FAILED(90)
}