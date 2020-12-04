package com.almacen.quique.util

class Constants {

    companion object{
        private const val URL_API_Base  = "/api"
        private const val URL_API_VERSION = "/v1"
        private const val URL_BASE = URL_API_Base + URL_API_VERSION

        // base API endpoint para product
        const val URL_BASE_PRODUCT = "$URL_BASE/products"
    }
}