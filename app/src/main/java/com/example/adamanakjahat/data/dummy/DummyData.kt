package com.example.adamanakjahat.data.dummy

import com.example.adamanakjahat.R
import com.example.adamanakjahat.data.model.Category
import com.example.adamanakjahat.data.model.Product

object DummyData {
    val categories = listOf(
        Category(0, "Semua", R.drawable.ic_launcher_foreground),
        Category(1, "Makanan", R.drawable.ic_launcher_foreground),
        Category(2, "Kerajinan", R.drawable.ic_launcher_foreground),
        Category(3, "Oleh-oleh", R.drawable.ic_launcher_foreground)
    )

    val products = listOf(
        Product(1, "Mendoan", "Mendoan hangat khas Banyumas.", 1, R.drawable.fotoproduk),
        Product(2, "Nopia", "Kue tradisional dengan isi gula merah.", 1, R.drawable.fotoproduk),
        Product(3, "Sapu Glagah", "Kerajinan tangan sapu dari bunga glagah.", 2, R.drawable.fotoproduk),
        Product(4, "Batik Banyumasan", "Batik dengan motif khas Banyumas.", 2, R.drawable.fotoproduk),
        Product(5, "Getuk Goreng", "Getuk goreng manis asli Sokaraja.", 3, R.drawable.fotoproduk),
        Product(6, "Kaos Banyumasan", "Kaos dengan tulisan ngapak.", 3, R.drawable.fotoproduk),
        Product(7, "Keripik Tempe", "Keripik tempe renyah dan gurih.", 1, R.drawable.fotoproduk),
        Product(8, "Miniatur Wayang", "Hiasan miniatur wayang kulit.", 2, R.drawable.fotoproduk)
    )
}
