package io.jason.bootbase.domain.model

import jakarta.persistence.*
import java.time.LocalDateTime


@Entity
@Table(name = "USER")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UID")
    val id: Long? = null,

    @Column(name = "USERID", length = 30)
    var userId: String = "",

    @Column(name = "USERNAME", length = 30)
    var userName: String = "",

    @Column(name = "PWD", length = 100)
    var pwd: String = "",

    @Column(name = "EMAIL", length = 100)
    var email: String = "",

    @Column(name = "REGIST_DATETIME")
    var registDatetime: LocalDateTime = LocalDateTime.now(),

    @Column(name = "UPDATE_DATETIME")
    var updateDatetime: LocalDateTime = LocalDateTime.now()

) {

}