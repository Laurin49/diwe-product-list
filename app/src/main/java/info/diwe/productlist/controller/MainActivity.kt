package info.diwe.productlist.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import info.diwe.productlist.EXTRA_CATEGORY
import info.diwe.productlist.R
import info.diwe.productlist.adapters.CategoryRecycleAdatper
import info.diwe.productlist.services.DataService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter : CategoryRecycleAdatper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryRecycleAdatper(this, DataService.categories) {category ->
            val productIntent = Intent(this, ProductsActivity::class.java)
            productIntent.putExtra(EXTRA_CATEGORY, category.title)
            startActivity(productIntent)
        }

        categoryListView.adapter = adapter

        categoryListView.layoutManager = LinearLayoutManager(this)
        categoryListView.setHasFixedSize(true)
    }
}
