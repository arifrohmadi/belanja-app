package uns.belanja.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uns.belanja.R
import uns.belanja.model.Products
import kotlinx.android.synthetic.main.item_list_product.view.*

class ListProductAdapter(val listProduct: ArrayList<Products>) :
    RecyclerView.Adapter<ListProductAdapter.ListProductViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListProductAdapter.ListProductViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_list_product, viewGroup, false)
        return ListProductViewHolder(view)
    }

    override fun getItemCount(): Int = listProduct.size

    override fun onBindViewHolder(holder: ListProductAdapter.ListProductViewHolder, position: Int) {
        holder.bind(listProduct[position])
    }

    class ListProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(products: Products) {
            with(itemView) {
                tvProductName.text = products.name
                tvProductPrice.text = products.price.toString()
                Glide.with(this).load(products.image).into(imgProduct)
            }
        }
    }
}