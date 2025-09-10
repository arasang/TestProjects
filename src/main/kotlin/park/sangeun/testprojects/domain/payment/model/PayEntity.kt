package park.sangeun.testprojects.domain.payment.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EntityListeners
import jakarta.persistence.Id
import jakarta.persistence.UniqueConstraint
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@Entity(name = "pay")
@EntityListeners(AuditingEntityListener::class)
data class PayEntity(
    @Id
    val id: String,
    @NotNull
    @Column(unique = true)
    val merchantTid: String,
    @NotNull
    val merchantId: Long,
    @NotNull
    val pMethodId: Long,
    @Positive
    val amount: Int,
    @Column(columnDefinition = "tinyint(2)")
    val paySt: Int,
    @Column(length=20)
    var errorCode: String? = null,
    @Column(length=255)
    var updateCause: String? = null
) {
    @CreatedDate
    @Column(columnDefinition = "datetime default current_timestamp")
    var createDate: LocalDateTime = LocalDateTime.now()

    @LastModifiedDate
    @Column(columnDefinition = "datetime default current_timestamp on update current_timestamp")
    var updateDate: LocalDateTime = LocalDateTime.now()
}
