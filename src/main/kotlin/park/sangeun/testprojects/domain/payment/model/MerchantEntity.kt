package park.sangeun.testprojects.domain.payment.model

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@Entity(name="merchant")
@EntityListeners(AuditingEntityListener::class)
data class MerchantEntity(
    @Column(length=25)
    val name: String,

    @Column(columnDefinition = "tinyint")
    val isActive: Boolean,

    val createAuid: Long,
    val updateAuid: Long,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0

    @CreatedDate
    @Column(columnDefinition = "datetime default current_timestamp")
    val createDate: LocalDateTime = LocalDateTime.now()

    @LastModifiedDate
    @Column(columnDefinition = "datetime default current_timestamp on update current_timestamp")
    val updateDate: LocalDateTime = LocalDateTime.now()
}
