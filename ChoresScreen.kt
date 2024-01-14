package com.example.room_aid_takjadi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ChoresScreen() {
    var choreItems by remember { mutableStateOf(listOf("Sapu sampah", "Kemas ruang tamu", "Basuh baju")) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(123, 216, 250)
    ) {
        Box {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Chores",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.White
                )
                Text(
                    "dd.MM.yyyy",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(16.dp))
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color(98, 144, 164)),
                    shape = MaterialTheme.shapes.medium
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        choreItems.forEachIndexed { index, itemText ->
                            ChoreItem(
                                index = index,
                                text = itemText,
                                onTextChanged = { updatedIndex, newText ->
                                    choreItems = choreItems.toMutableList().apply {
                                        set(updatedIndex, newText)
                                    }
                                }
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Button(
                        onClick = { /* TODO: Implement history action */ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
                        modifier = Modifier
                            .height(IntrinsicSize.Min) // This will constrain the height
                            .width(150.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = "History",
                                tint = Color.White
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "History",
                                color = Color.White
                            )
                        }
                    }
                }


            }
            FloatingActionButton(
                onClick = {
                    choreItems = choreItems + listOf("") // Add an empty chore item
                },
                contentColor = Color.White,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Chore"
                )
            }
        }
    }
}

@Composable
fun ChoreItem(index: Int, text: String, onTextChanged: (Int, String) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Checkbox(
            checked = false,
            onCheckedChange = { /* TODO: Implement check action */ },
            colors = CheckboxDefaults.colors(checkmarkColor = Color.White)
        )
        BasicTextField(
            value = text,
            onValueChange = {
                onTextChanged(index, it)
            },
            textStyle = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp)
        )

    }
}

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun ChoresScreenPreview() {
    ChoresScreen()
}
