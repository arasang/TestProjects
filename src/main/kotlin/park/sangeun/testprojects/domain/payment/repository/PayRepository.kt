package park.sangeun.testprojects.domain.payment.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import park.sangeun.testprojects.domain.payment.model.PayEntity

@Repository
interface PayRepository: JpaRepository<PayEntity, String> {
    @Modifying
    @Query(
        value = """
            INSERT INTO pay (id, merchant_tid, merchant_id, p_method_id, amount, pay_st)
            VALUES (?1, ?2, ?3, ?4, ?5, ?6)
        """,
        nativeQuery = true
    )
    fun insertPay(
        id: String,
        merchantTid: String,
        merchantId: Long,
        pMethodId: Long,
        amount: Int,
        payStatus: Int
    ): Int

}