package com.almacen.quique.business

import com.almacen.quique.model.Product

interface IProductBusiness {

    fun list() : List<Product>
    fun load(idProduct: Long) : Product
    fun save(product: Product) : Product
    fun remove(idProduct: Long)
}