
package com.example.counterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

// Warna tema pink
private val PinkBackground = Color(0xFFFFF0F5)
private val PinkDark = Color(0xFFBE185D)
private val PinkMain = Color(0xFFEC4899)
private val PinkLight = Color(0xFFF472B6)
private val PinkText = Color(0xFF9D174D)

// ViewModel
class CounterViewModel : ViewModel() {

    var count by mutableIntStateOf(0)
        private set

    fun increment() {
        count++
    }

    fun decrement() {
        count--
    }

    fun reset() {
        count = 0
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                CounterScreen()
            }
        }
    }
}

@Composable
fun CounterScreen(
    counterViewModel: CounterViewModel = viewModel()
) {
    val count = counterViewModel.count

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = PinkBackground
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            // Kartu utama dengan bayangan pop-up
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(
                        elevation = 18.dp,
                        shape = RoundedCornerShape(28.dp),
                        clip = false,
                        ambientColor = PinkDark,
                        spotColor = PinkDark
                    ),
                shape = RoundedCornerShape(28.dp),
                color = Color.White
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    // Header
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .shadow(
                                elevation = 8.dp,
                                shape = RoundedCornerShape(20.dp),
                                ambientColor = PinkDark,
                                spotColor = PinkDark
                            ),
                        shape = RoundedCornerShape(20.dp),
                        color = PinkDark
                    ) {
                        Column(
                            modifier = Modifier.padding(24.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "COUNTER APP",
                                fontSize = 27.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Text(
                                text = "Aplikasi Penghitung Angka",
                                fontSize = 14.sp,
                                color = Color(0xFFFFE4EF)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(28.dp))

                    // Identitas mahasiswa
                    Text(
                        text = "Shafiyyah Najah Wijaya",
                        fontSize = 16.sp,
                        color = Color.DarkGray,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "24515040711034",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = PinkText,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(28.dp))

                    // Angka counter
                    Text(
                        text = count.toString(),
                        fontSize = 72.sp,
                        fontWeight = FontWeight.Bold,
                        color = PinkMain
                    )

                    Text(
                        text = "Nilai Counter",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )

                    Spacer(modifier = Modifier.height(28.dp))

                    // Tombol Down dan Up
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement =
                            Arrangement.spacedBy(12.dp)
                    ) {
                        Button(
                            onClick = {
                                counterViewModel.decrement()
                            },
                            modifier = Modifier
                                .weight(1f)
                                .height(52.dp),
                            shape = RoundedCornerShape(14.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = PinkLight
                            )
                        ) {
                            Text(
                                text = "− Down",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Button(
                            onClick = {
                                counterViewModel.increment()
                            },
                            modifier = Modifier
                                .weight(1f)
                                .height(52.dp),
                            shape = RoundedCornerShape(14.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = PinkMain
                            )
                        ) {
                            Text(
                                text = "+ Up",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    // Tombol Reset
                    Button(
                        onClick = {
                            counterViewModel.reset()
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(52.dp),
                        shape = RoundedCornerShape(14.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = PinkDark
                        )
                    ) {
                        Text(
                            text = "Reset",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}
