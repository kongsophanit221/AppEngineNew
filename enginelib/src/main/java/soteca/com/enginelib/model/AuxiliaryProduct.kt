package com.soteca.loyaltyuserengine.model

import android.os.Parcel
import android.os.Parcelable
import soteca.com.genisysandroid.framwork.model.EntityCollection
import soteca.com.genisysandroid.framwork.model.EntityReference

class AuxiliaryProduct : Product {

    override val auxiliaryProductsAdd: ArrayList<AuxiliaryProduct>
        get() {
            var tem: ArrayList<AuxiliaryProduct> = ArrayList()
            tem.addAll(auxiliaryProducts.filter { it.isSelect == false })
            
            return tem
        }

    //    var description: String? = null // The Name of POC Component Entity
    var isSelect = false //for custom select product auxiliary from product
    var isHasAuxiliary: Boolean = false
        get() = auxiliaryProducts.size > 0

//    override var auxiliaryProducts: ArrayList<AuxiliaryProduct> = ArrayList()

    constructor() : super()

    constructor(attribute: EntityCollection.Attribute) : super(attribute)

    constructor(newAuxiliaryProduct: AuxiliaryProduct, description: String?) : this() {
        this.id = newAuxiliaryProduct.id
        this.name = newAuxiliaryProduct.name
        this.venue = newAuxiliaryProduct.venue
        this.bundleId = newAuxiliaryProduct.bundleId
        this.category = newAuxiliaryProduct.category
        this.price = newAuxiliaryProduct.price
        this.min = newAuxiliaryProduct.min
        this.max = newAuxiliaryProduct.max
        this.description = description
    }

    override fun addOnComponent(product: AuxiliaryProduct) {
        auxiliaryProducts.add(product)
    }

    override fun toString(): String {
        return "auxiliary id: " + id + " name: " + name + " bundleId: " + bundleId
    }

    override fun clone(newProduct: Product?): Product {

        val product = AuxiliaryProduct()

        product.id = id
        product.name = name
        product.price = price
        product.image = image
        product.category = category
        product.venue = venue
        product.min = min
        product.max = max
        product.bundleId = bundleId
        product.description = description
        product.isSelect = isSelect
        product.isAvailable = isAvailable

        auxiliaryProducts.forEach {
            product.auxiliaryProducts.add(it.clone() as AuxiliaryProduct)
        }

        return super.clone(product as Product)
    }
}