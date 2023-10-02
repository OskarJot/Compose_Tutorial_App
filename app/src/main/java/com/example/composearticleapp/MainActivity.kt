package com.example.composearticleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticleapp.ui.theme.ComposeArticleAppTheme
import androidx.compose.foundation.Image as Image

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ImageTitle(
                        first = getString(R.string.title),
                        second = getString(R.string.first_article),
                        third = getString(R.string.second_article))
                }
            }
        }
    }
}

@Composable
fun ImageTitle(first: String, second: String, third: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)
    Column (
        modifier = modifier,
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )
        Article(
            first = first,
            second = second,
            third = third,
            modifier = modifier
        )
    }
}

@Composable
fun Article(first: String, second: String, third: String, modifier: Modifier = Modifier) {
    Text(
        text = first,
        fontSize = 24.sp,
        modifier = Modifier.padding(16.dp)
    )
    Text(
        text = second,
        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
        textAlign = TextAlign.Justify
    )
    Text(
        text = third,
        textAlign = TextAlign.Justify,
        modifier = Modifier.padding(16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun Oskar() {
    ComposeArticleAppTheme {
        ImageTitle(stringResource(R.string.title), stringResource(R.string.first_article), stringResource(
            R.string.second_article
        )
        )
    }
}