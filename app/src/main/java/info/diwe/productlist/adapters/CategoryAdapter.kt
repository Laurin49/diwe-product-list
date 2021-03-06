package info.diwe.productlist.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import info.diwe.productlist.R
import info.diwe.productlist.model.Category

class CategoryAdapter(val context: Context, val categories: List<Category>): BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val categoryView: View
        val holder : ViewHolder

        if (convertView == null) {
            // if first time shown
            categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item, null)

            holder = ViewHolder()
            holder.categoryImage = categoryView.findViewById(R.id.categoryImage)
            holder.categoryName = categoryView.findViewById(R.id.categoryName)
            println("CategoryAdapter: I exist for the first time")

            categoryView.tag = holder
        } else {
            // reuse view and cells
            holder = convertView.tag as ViewHolder
            categoryView = convertView
            println("CategoryAdapter: Go green, recycle !")
        }


        val category = categories[position]

        val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)

        holder.categoryName?.text = category.title
        holder.categoryImage?.setImageResource(resourceId)

        return categoryView
    }

    override fun getItem(position: Int): Any {
        return categories[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return categories.count()
    }


    private class ViewHolder {
        var categoryImage: ImageView? = null
        var categoryName: TextView? = null
    }
}