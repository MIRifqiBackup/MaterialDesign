package com.mobile.miftakhulilmanrifqi.a205410082.materialdesign.network

import android.content.res.Resources
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mobile.miftakhulilmanrifqi.a205410082.materialdesign.R
import java.io.BufferedReader
import java.util.*

class ProductEntry(val title: String,val url: String, val price: String) {

    companion object {
        fun initProductEntryList(resources: Resources): List<ProductEntry> {
            val inputStream = resources.openRawResource(R.raw.products)
            val jsonProductsString = inputStream.bufferedReader().use(BufferedReader::readText)
            val gson = Gson()
            val productListType = object : TypeToken<ArrayList<ProductEntry>>() {}.type
            return gson.fromJson(jsonProductsString, productListType)
        }
    }
}
