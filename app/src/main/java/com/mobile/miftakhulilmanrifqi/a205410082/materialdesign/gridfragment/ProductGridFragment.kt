package com.mobile.miftakhulilmanrifqi.a205410082.materialdesign.gridfragment

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobile.miftakhulilmanrifqi.a205410082.materialdesign.NavigationIconClickListener
import com.mobile.miftakhulilmanrifqi.a205410082.materialdesign.R
import com.mobile.miftakhulilmanrifqi.a205410082.materialdesign.network.ProductEntry
import kotlinx.android.synthetic.main.shr_product_grid_fragment.view.*

class ProductGridFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.shr_product_grid_fragment, container, false)
        (activity as AppCompatActivity).setSupportActionBar(view.app_bar)

        // Set up the RecyclerView
        view.recycler_view.setHasFixedSize(true)
        val gridLayoutManager = GridLayoutManager(context, 2, RecyclerView.HORIZONTAL, false)
        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return if (position % 3 == 2) 2 else 1
            }
        }
        view.recycler_view.layoutManager = GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)
        val adapter = ProductCardRecyclerViewAdapter(this, ProductEntry.initProductEntryList(resources))
        view.recycler_view.adapter = adapter

        // Set cut corner background for API 23+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            view.product_grid.background = context?.getDrawable(R.drawable.shr_product_grid_background_shape)
        }

        // Set up the toolbar.
        (activity as AppCompatActivity).setSupportActionBar(view.app_bar)
        view.app_bar.setNavigationOnClickListener(NavigationIconClickListener(
            requireActivity(),
            view.product_grid,
            AccelerateDecelerateInterpolator(),
            ContextCompat.getDrawable(requireContext(), R.drawable.shr_branded_menu), // Menu open icon
            ContextCompat.getDrawable(requireContext(), R.drawable.shr_close_menu))) // Menu close icon


        return view
        //        view.recycler_view.setHasFixedSize(true)
//        view.recycler_view.layoutManager =
//            GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)
//        val adapter = ProductCardRecyclerViewAdapter(this, ProductEntry.initProductEntryList(resources))
//        view.recycler_view.adapter = adapter
    }


    override fun onCreateOptionsMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.shr_toolbar_menu, menu)
        super.onCreateOptionsMenu(menu, menuInflater)
    }
}
