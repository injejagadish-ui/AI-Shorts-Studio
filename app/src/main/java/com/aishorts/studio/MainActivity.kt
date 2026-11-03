package com.aishorts.studio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShortsApp()
        }
    }
}

@Composable
fun ShortsApp() {
    var prompt by remember { mutableStateOf("") }
    var duration by remember { mutableStateOf("30 seconds") }
    var status by remember { mutableStateOf("Ready to create your video!") }

    val bg = Color(0xFF10101C)
    val purple = Color(0xFF8B5CF6)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(bg)
            .verticalScroll(rememberScrollState())
            .padding(20.dp)
    ) {

        Text(
            "AI SHORTS STUDIO",
            color = purple,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(25.dp))

        Text(
            "Create AI Videos ✨",
            color = Color.White,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            "Turn your imagination into videos.",
            color = Color.LightGray,
            fontSize = 14.sp
        )

        Spacer(Modifier.height(30.dp))

        Text("Enter your video prompt",
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold)

        Spacer(Modifier.height(12.dp))

        OutlinedTextField(
            value = prompt,
            onValueChange = { prompt = it },
            placeholder = {
                Text("A magical jungle adventure...")
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            shape = RoundedCornerShape(16.dp)
        )

        Spacer(Modifier.height(22.dp))

        Text("Video duration",
            color = Color.White,
            fontSize = 17.sp)

        Spacer(Modifier.height(10.dp))

        listOf("5 seconds", "10 seconds", "30 seconds")
            .forEach { option ->
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = duration == option,
                        onClick = { duration = option },
                        colors = RadioButtonDefaults.colors(
                            selectedColor = purple
                        )
                    )
                    Text(option, color = Color.White)
                }
            }

        Spacer(Modifier.height(25.dp))

        Button(
            onClick = {
                status = if (prompt.isBlank()) {
                    "Please enter a video prompt."
                } else {
                    "Video generation will be connected in the next step!"
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(58.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = purple
            ),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                "✨ Generate AI Video",
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(Modifier.height(20.dp))

        Text(
            status,
            color = Color.White,
            fontSize = 14.sp
        )
    }
}
