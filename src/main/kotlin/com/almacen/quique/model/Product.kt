package com.almacen.quique.model


import javax.persistence.*


@Entity
@Table
data class Product( val cant : Int,
                    val precio : Int,
                    val nombre: String,
                    val categoria : String) {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
}