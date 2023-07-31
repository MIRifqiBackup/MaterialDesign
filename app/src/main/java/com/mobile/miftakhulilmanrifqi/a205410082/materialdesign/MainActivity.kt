package com.mobile.miftakhulilmanrifqi.a205410082.materialdesign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mobile.miftakhulilmanrifqi.a205410082.materialdesign.gridfragment.ProductGridFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shr_main_activity)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.container, ProductGridFragment())
                .commit()
        }
    }
}
