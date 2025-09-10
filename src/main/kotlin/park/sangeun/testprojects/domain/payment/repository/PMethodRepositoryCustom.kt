package park.sangeun.testprojects.domain.payment.repository

import park.sangeun.testprojects.domain.payment.model.PMethodEntity

interface PMethodRepositoryCustom {
    fun findPMethodById(id: Long): PMethodEntity?
}