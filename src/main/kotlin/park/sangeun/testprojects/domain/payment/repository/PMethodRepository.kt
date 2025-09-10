package park.sangeun.testprojects.domain.payment.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import park.sangeun.testprojects.domain.payment.model.PMethodEntity

@Repository
interface PMethodRepository: JpaRepository<PMethodEntity, Long>, PMethodRepositoryCustom {

}