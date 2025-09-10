package park.sangeun.testprojects.domain.payment

import org.springframework.dao.DataIntegrityViolationException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import park.sangeun.testprojects.domain.payment.model.*
import park.sangeun.testprojects.domain.payment.repository.MerchantRepository
import park.sangeun.testprojects.domain.payment.repository.PMethodRepository
import park.sangeun.testprojects.domain.payment.repository.PayRepository
import kotlin.random.Random
import kotlin.random.nextInt

@Service
class PaymentService(
    private val pMethodRepository: PMethodRepository,
    private val merchantRepository: MerchantRepository,
    private val payRepository: PayRepository
) {

    @Transactional
    fun pay(request: PayRequest): PayResponse {
        // aop에서 이미 검증 완료.
        val payId = "PAY${System.currentTimeMillis()}${Random.nextInt(100, 1000)}"

        val payEntity = PayEntity(
            id = payId,
            merchantTid = request.merchantTid,
            merchantId = request.merchantId,
            pMethodId = request.pMethodId,
            amount = request.amount,
            paySt = PaymentStatus.REGISTER.state
        )

        try {
            payRepository.insertPay(
                id = payEntity.id,
                merchantTid = payEntity.merchantTid,
                merchantId = payEntity.merchantId,
                pMethodId = payEntity.pMethodId,
                amount = payEntity.amount,
                payStatus = payEntity.paySt
            )
        } catch (e: DataIntegrityViolationException) {
            throw Exception("결제키 중복")
        }

        // kafka 발송


        // @TODO: 응답 파라미터 새로 생성 필요
        return PayResponse("")

    }

    fun getPMethod(id: Long): PMethodEntity {
        return pMethodRepository.findPMethodById(id)
            ?: throw Exception("존재 하지 않는 결제 수단")
    }

    fun getMerchant(id: Long): MerchantEntity {
        return merchantRepository.findByIdAndIsActiveIsTrue(id)
            ?: throw Exception("존재 하지 않는 가맹점")
    }
}