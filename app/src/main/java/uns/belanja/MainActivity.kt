package uns.belanja

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import uns.belanja.adapter.ListProductAdapter
import uns.belanja.model.Products
import uns.belanja.model.ProductsData

class MainActivity : AppCompatActivity() {

    private var list: ArrayList<Products> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showListProducts()
    }

    private fun showListProducts() {
        list.addAll(ProductsData.listProduct)
        rvProducts.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = ListProductAdapter(list)
            setHasFixedSize(true)
        }
    }
}
