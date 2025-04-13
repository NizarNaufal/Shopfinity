package id.devnzr.shopfinity.home.screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.IconButton
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import id.devnzr.shopfinity.home.R

@Composable
fun TopAppBarItemComponent(
    currentSearchText: String,
    onSearchTextChange: (String) -> Unit,
    onSearch: () -> Unit,
    onToggleExpand: () -> Unit,
) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(12.dp),
    ) {
        Row(
            Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = CenterVertically
            ) {
                AsyncImage(
                    model = "https://static.vecteezy.com/system/resources/previews/006/487/917/original/man-avatar-icon-free-vector.jpg",
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(35.dp),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Hi, John", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }

            Icon(
                modifier = Modifier
                    .size(24.dp),
                painter = painterResource(id = R.drawable.ic_alert),
                contentDescription = null,
                tint = Color.Blue
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = CenterVertically
        ) {
            androidx.compose.material.TextField(
                value = currentSearchText,
                onValueChange = {
                    onSearchTextChange(it)
                },
                placeholder = {
                    Text(
                        text = "Search",
                    )
                },

                modifier = Modifier
                    .fillMaxWidth(0.80f)
                    .background(Color.White, shape = RoundedCornerShape(8.dp))
                    .clickable {},
                shape = RoundedCornerShape(size = 8.dp),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Words,
                    autoCorrect = true,
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Search
                ),
                keyboardActions = KeyboardActions(
                    onSearch = {
                        onSearch()
                    }
                ),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.White,
                    disabledTextColor = Color.White,
                    backgroundColor = Color.White,
                    focusedIndicatorColor = Color.White,
                    unfocusedIndicatorColor = Color.White,
                    disabledIndicatorColor = Color.White
                ),
                textStyle = TextStyle(color = Color.Black),
                maxLines = 1,
                singleLine = true,
                leadingIcon = {
                    Icon(
                        modifier = Modifier
                            .size(24.dp),
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = null,
                        tint = Color.Blue
                    )
                }
            )

            IconButton(onClick = onToggleExpand) {
                Icon(
                    modifier = Modifier
                        .size(55.dp)
                        .clip(
                            shape = RoundedCornerShape(
                                size = 8.dp
                            )
                        )
                        .background(Color.White)
                        .padding(
                            start = 4.dp,
                            end = 4.dp,
                            top = 4.dp,
                            bottom = 4.dp
                        ),
                    painter = painterResource(id = R.drawable.ic_filter),
                    contentDescription = null,
                    tint = Color.Blue
                )
            }
        }
    }
}
