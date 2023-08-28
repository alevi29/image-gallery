package com.example.imagegallery

import android.os.Bundle
import android.view.SurfaceControlViewHost.SurfacePackage
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.imagegallery.ui.theme.ImageGalleryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImageGalleryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                )

                {
                    imageGalleryLayout()
                }

            }
        }
    }
}

val imgDescription = mapOf(0 to Pair("Moonlight", "(2023)"), 1 to Pair("Flowers at Dusk", "(2022)"),
    2 to Pair("Lilac", "(2021)"), 3 to Pair("Lily of the Valley", "(2020)"))


@Composable
fun imageGalleryLayout(
)

{
    val images = arrayOf(R.drawable._0img, R.drawable._1img, R.drawable._2img, R.drawable._3img)

    var imageIndex by remember { mutableStateOf(0)}

    Column(
        modifier = Modifier
            .padding(32.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    )

    {
        Column(
            modifier = Modifier
                .padding(bottom = 32.dp)
                .padding(top = 100.dp)
        )

        {
            Surface(
                border = BorderStroke(1.dp, Color(0.96f, 0.97f, 0.96f, 1.0f)),
                color = Color(0.96f, 0.97f, 0.96f, 1.0f),
                shadowElevation = 24.dp
            )
            {
                Column() {
                    imgDescription[imageIndex]?.let {
                        Text(
                            modifier = Modifier.padding(8.dp),
                            text = it.first,
                            style = MaterialTheme.typography.headlineSmall,
                            fontFamily = FontFamily.Monospace
                        )
                    }

                    imgDescription[imageIndex]?.let {
                        Text(
                            modifier = Modifier.padding(8.dp, 0.dp, 0.dp, 8.dp),
                            text = it.second,
                            style = MaterialTheme.typography.bodyMedium,
                            fontFamily = FontFamily.Monospace,
                        )
                    }
                }
            }
        }

        Surface(
            border = BorderStroke(2.dp, Color.Transparent),
            shadowElevation = 24.dp,
        ) {
            Image(
                painter = painterResource(id = images[imageIndex]),
                contentDescription = null,
                modifier = Modifier
                    .padding(16.dp)
            )
        }

        Spacer(modifier = Modifier.height(60.dp))

        Row() {
                Button(onClick = {imageIndex = ((imageIndex - 1) % 4 + 4) % 4},
                    border = BorderStroke(1.dp, Color(0.46f, 0.5f, 0.78f, 1.0f)),
                    colors = ButtonDefaults.buttonColors(Color(0.46f, 0.5f, 0.78f, 1.0f)),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .padding(end = 28.dp)
                        .width(130.dp)
                ) {
                    Text(
                        textAlign = TextAlign.Center,
                        text = "Previous",
                        fontFamily = FontFamily.Monospace,
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.Black
                    )
                }

                Button(onClick = {imageIndex = (imageIndex + 1) % 4},
                    border = BorderStroke(1.dp, Color(0.46f, 0.5f, 0.8f, 1.0f)),
                    colors = ButtonDefaults.buttonColors(Color(0.46f, 0.5f, 0.8f, 1.0f)),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .padding(start = 28.dp)
                        .width(130.dp)
                    ) {
                    Text(
                        textAlign = TextAlign.Center,
                        text = "Next",
                        fontFamily = FontFamily.Monospace,
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.Black
                    )
                }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ImageGalleryTheme {
        imageGalleryLayout()
    }
}