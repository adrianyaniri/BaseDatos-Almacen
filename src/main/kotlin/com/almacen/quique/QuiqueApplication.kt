package com.almacen.quique

import com.almacen.quique.dao.ProductRepository
import com.almacen.quique.exception.ProductException
import com.almacen.quique.model.Product
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class QuiqueApplication : CommandLineRunner{

	@Autowired
	val productRepository : ProductRepository? = null

	override fun run(vararg args: String?){

		val producto = Product(2,100,"coca-cola","gaseosa")
		val producto2 = Product(10,85,"pepsi","gaseaosa")

		productRepository!!.save(producto)
		productRepository!!.save(producto2)
	}
}

fun main(args: Array<String>) {
	runApplication<QuiqueApplication>(*args)
}
