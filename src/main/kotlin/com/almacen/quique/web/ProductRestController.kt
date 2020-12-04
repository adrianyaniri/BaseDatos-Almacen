package com.almacen.quique.web

import com.almacen.quique.business.IProductBusiness
import com.almacen.quique.exception.NotFoundException
import com.almacen.quique.exception.ProductException
import com.almacen.quique.model.Product
import com.almacen.quique.util.Constants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(Constants.URL_BASE_PRODUCT)
class ProductRestController {

    @Autowired
    val productBusiness : IProductBusiness? = null

    @GetMapping("")
    fun list() : ResponseEntity<List<Product>> =
        try { ResponseEntity(productBusiness!!.list(), HttpStatus.OK) }
        catch (e: Exception){ ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)}

    @GetMapping("/{id}")
    fun load(@PathVariable("id") idProduct :Long) : ResponseEntity<Any> =
        try { ResponseEntity(productBusiness!!.load(idProduct), HttpStatus.OK)}
        catch (e: ProductException){ ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR) }
        catch (e:NotFoundException) { ResponseEntity(HttpStatus.NOT_FOUND)}


    @PostMapping("")
    fun insert(@RequestBody product: Product) : ResponseEntity<Any> =
        try {
            productBusiness!!.save(product)
            val responseHeader = HttpHeaders()
            responseHeader.set("location ", Constants.URL_BASE_PRODUCT + "/" + product.id)
            ResponseEntity(responseHeader, HttpStatus.CREATED)
        }
        catch (e:ProductException){ ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR) }

    @PutMapping("")
    fun update(@RequestBody product: Product) : ResponseEntity<Any> =
        try {
            productBusiness!!.save(product)
            ResponseEntity(HttpStatus.OK)
        }
        catch (e: ProductException){ ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR) }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") idProduct: Long) : ResponseEntity<Any> =
        try {
            productBusiness!!.remove(idProduct)
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
        catch (e:NotFoundException) { ResponseEntity(HttpStatus.NOT_FOUND) }
}