package info.diwe.productlist.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import info.diwe.productlist.R
import info.diwe.productlist.model.Category

class CategoryRecycleAdatperOwn(val context: Context, val categories: List<Category>) : RecyclerView.Adapter<CategoryRecycleAdatperOwn.Holder>() {

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryImage = itemView.findViewById<ImageView>(R.id.categoryImage)
        val categoryName = itemView.findViewById<TextView>(R.id.categoryName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_list_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val category = categories[position]
        
        val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)
        holder.categoryImage.setImageResource(resourceId)
        holder.categoryName.text = category.title
    }

    override fun getItemCount(): Int {
        return categories.count()
    }
}