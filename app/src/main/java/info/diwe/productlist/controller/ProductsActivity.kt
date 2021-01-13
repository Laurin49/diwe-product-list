package info.diwe.productlist.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import info.diwe.productlist.EXTRA_CATEGORY
import info.diwe.productlist.R

class ProductsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        Toast.makeText(this, "Product Category : $categoryType", Toast.LENGTH_LONG).show()
    }
}
