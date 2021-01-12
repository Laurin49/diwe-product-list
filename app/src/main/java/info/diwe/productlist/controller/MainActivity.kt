package info.diwe.productlist.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import info.diwe.productlist.R
import info.diwe.productlist.adapters.CategoryAdapter
import info.diwe.productlist.model.Category
import info.diwe.productlist.services.DataService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter : CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryAdapter(
            this,
            DataService.categories)

        categoryListView.adapter = adapter
    }
}
