package com.example.adamanakjahat.ui.screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adamanakjahat.data.dummy.DummyData
import com.example.adamanakjahat.data.model.Category
import com.example.adamanakjahat.data.model.Product
import com.example.adamanakjahat.ui.theme.JualanTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DaftarProdukScreen(modifier: Modifier = Modifier) {
    var selectedCategoryId by remember { mutableIntStateOf(0) }
    
    val filteredProducts = if (selectedCategoryId == 0) {
        DummyData.products
    } else {
        DummyData.products.filter { it.categoryId == selectedCategoryId }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Produk Lokal") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(DummyData.categories) { category ->
                    CategoryItem(
                        category = category,
                        isSelected = selectedCategoryId == category.id,
                        onClick = { selectedCategoryId = category.id }
                    )
                }
            }

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(filteredProducts) { product ->
                    ProductItemCard(product = product)
                }
            }
        }
    }
}

@Composable
fun CategoryItem(
    category: Category,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        onClick = onClick,
        shape = RoundedCornerShape(20.dp),
        color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant,
        contentColor = if (isSelected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurfaceVariant,
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = category.iconRes),
                contentDescription = null,
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = category.name,
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}

@Composable
fun ProductItemCard(
    product: Product,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                Toast.makeText(context, "Clicked: ${product.name}", Toast.LENGTH_SHORT).show()
            },
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column {
            Image(
                painter = painterResource(id = product.imageRes),
                contentDescription = product.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp)),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = product.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = product.description,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DaftarProdukScreenPreview() {
    JualanTheme(darkTheme = false) {
        DaftarProdukScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun DaftarProdukScreenDarkPreview() {
    JualanTheme(darkTheme = true) {
        DaftarProdukScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryItemPreview() {
    JualanTheme(darkTheme = false) {
        Row(modifier = Modifier.padding(8.dp)) {
            CategoryItem(
                category = DummyData.categories[1],
                isSelected = true,
                onClick = {}
            )
            Spacer(modifier = Modifier.width(8.dp))
            CategoryItem(
                category = DummyData.categories[2],
                isSelected = false,
                onClick = {}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryItemDarkPreview() {
    JualanTheme(darkTheme = true) {
        Row(modifier = Modifier.padding(8.dp)) {
            CategoryItem(
                category = DummyData.categories[1],
                isSelected = true,
                onClick = {}
            )
            Spacer(modifier = Modifier.width(8.dp))
            CategoryItem(
                category = DummyData.categories[2],
                isSelected = false,
                onClick = {}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductItemCardPreview() {
    JualanTheme(darkTheme = false) {
        Box(modifier = Modifier.padding(16.dp).width(180.dp)) {
            ProductItemCard(product = DummyData.products[0])
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductItemCardDarkPreview() {
    JualanTheme(darkTheme = true) {
        Box(modifier = Modifier.padding(16.dp).width(180.dp)) {
            ProductItemCard(product = DummyData.products[0])
        }
    }
}
