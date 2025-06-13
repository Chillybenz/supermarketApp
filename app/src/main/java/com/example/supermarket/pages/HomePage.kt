package com.example.supermarket.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.supermarket.Data.ProductCategory
import com.example.supermarket.Data.ProductViewModel

@Composable
fun HomePage(modifier: Modifier = Modifier) {
    val viewModel: ProductViewModel = viewModel()
    val categories by viewModel.getAllCategories().collectAsState(initial = emptyList())
    val groupedCategories = categories.chunked(2)

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
        modifier = modifier.fillMaxSize()
    ) {
        items(groupedCategories) { pair ->
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .width(160.dp) // σταθερό πλάτος για ομοιομορφία
            ) {
                pair.forEach { category ->
                    CategoryCard(category)
                }
            }
        }
    }
}

@Composable
fun CategoryCard(category: ProductCategory) {
    val context = LocalContext.current
    val imageResId = remember(category.imageUrl) {
        context.resources.getIdentifier(
            category.imageUrl.removeSuffix(".png"),
            "drawable",
            context.packageName
        )
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(12.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f), // 💡 σταθερό τετράγωνο πλαίσιο
                contentAlignment = Alignment.Center
            ) {
                if (imageResId != 0) {
                    Image(
                        painter = painterResource(id = imageResId),
                        contentDescription = category.name,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(8.dp))
                    )
                } else {
                    Text(
                        text = "⚠",
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = category.name,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}
