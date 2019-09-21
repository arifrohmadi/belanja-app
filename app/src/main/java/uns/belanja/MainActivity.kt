package uns.belanja

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import uns.belanja.adapter.ListProductAdapter
import uns.belanja.data.model.Product
import uns.belanja.data.model.ProductsData

class MainActivity : AppCompatActivity() {

    private var list: ArrayList<Product> = arrayListOf()
    private lateinit var listProductAdapter: ListProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showListProducts()
        setListClickAction()
        setupAddProduct()
    }

    private fun showListProducts() {
        list.addAll(ProductsData.listProduct)
        listProductAdapter = ListProductAdapter(list)

        rvProducts.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = listProductAdapter
            setHasFixedSize(true)
        }
    }

    private fun setupAddProduct(){
        btnAddProduct.setOnClickListener {
            val detailIntent = Intent(
                this,
                DetailProductActivity::class.java
            )
            startActivity(detailIntent)
        }
    }

    private fun setListClickAction(){
        listProductAdapter.setOnItemClickCallback(
            object : ListProductAdapter.OnItemClickCallback{
                override fun onItemClick(data: Product) {
                    val manageDetailIntent = Intent(this@MainActivity,
                        DetailProductActivity::class.java).apply{
                        putExtra(DetailProductActivity.EXTRA_NAME, data.name)
                        putExtra(DetailProductActivity.EXTRA_IMAGE_URL, data.image)
                        putExtra(DetailProductActivity.EXTRA_PRICE, data.price.toString())
                    }
                    startActivity(manageDetailIntent)
                }
            }
        )
    }
}
