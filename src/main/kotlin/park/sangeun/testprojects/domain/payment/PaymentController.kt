package park.sangeun.testprojects.domain.payment

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import park.sangeun.testprojects.domain.payment.model.PayRequest
import park.sangeun.testprojects.domain.payment.model.PayResponse

@RestController
@RequestMapping("/pay")
class PaymentController(
    private val paymentService: PaymentService
) {
    @PostMapping
    fun pay(@RequestBody request: PayRequest): PayResponse {
        paymentService.
    }
}