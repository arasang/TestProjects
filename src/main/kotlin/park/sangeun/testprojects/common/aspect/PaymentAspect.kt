package park.sangeun.testprojects.common.aspect

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.stereotype.Component
import park.sangeun.testprojects.domain.payment.PaymentService
import park.sangeun.testprojects.domain.payment.model.PayRequest

@Aspect
@Component
class PaymentAspect(
    private val paymentService: PaymentService
) {
    @Before("execution(* park.sangeun.testprojects.domain.payment..controller..*(..))")
    fun verifyBefore(joinPoint: JoinPoint) {
        joinPoint.args.forEach { request ->
            when (request) {
                is PayRequest-> {
                    // 1. payment method check
                    paymentService.getPMethod(request.pMethodId)
                    // 2. merchant check
                    paymentService.getMerchant(request.merchantId)
                }
            }
        }
    }
}