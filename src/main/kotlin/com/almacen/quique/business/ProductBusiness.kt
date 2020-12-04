package com.almacen.quique.business

import com.almacen.quique.dao.ProductRepository
import com.almacen.quique.exception.NotFoundException
import com.almacen.quique.exception.ProductException
import com.almacen.quique.model.Product
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*


@Service
class ProductBusiness : IProductBusiness {

    @Autowired
    val productRepository : ProductRepository? = null

    @Throws(ProductException::class)
    override fun list(): List<Product> =
        try { productRepository!!.findAll() } catch (e:Exception){ throw ProductException(e.message) }


    @Throws(NotFoundException::class, ProductException::class)
    override fun load(idProduct: Long): Product {
        val op: Optional<Product>

        try { op = productRepository!!.findById(idProduct) } catch (e: Exception) { throw ProductException(e.message) }
        if (!op.isPresent) throw NotFoundException("no se encontro el producto $idProduct")
        return op.get()
    }

    @Throws(ProductException::class)
    override fun save(product: Product) =
        try { productRepository!!.save(product) }
        catch (e: Exception){ throw ProductException(e.message) }


    override fun remove(idProduct: Long) {
        val op: Optional<Product>

        try { op = productRepository!!.findById(idProduct) } catch (e: Exception) { throw ProductException(e.message) }
        if (!op.isPresent) throw NotFoundException("no se encontro el producto $idProduct")
        else try { productRepository!!.deleteById(idProduct) } catch (e: Exception) { throw ProductException(e.message) }
    }
}