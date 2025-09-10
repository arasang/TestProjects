package park.sangeun.testprojects.domain.payment.repository

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import park.sangeun.testprojects.domain.payment.model.PMethodEntity
import park.sangeun.testprojects.domain.payment.model.QPMethodEntity
import java.time.LocalDateTime

class PMethodRepositoryCustomImpl: PMethodRepositoryCustom, QuerydslRepositorySupport(PMethodEntity::class.java) {
    private val pMethod = QPMethodEntity.pMethodEntity

    override fun findPMethodById(id: Long): PMethodEntity? {
        return from(pMethod)
            .where(
                pMethod.isActive.isTrue,
                pMethod.startDate.loe(LocalDateTime.now()),
                pMethod.endDate.isNull.or(pMethod.endDate.gt(LocalDateTime.now()))
            )
            .fetchOne()
    }
}