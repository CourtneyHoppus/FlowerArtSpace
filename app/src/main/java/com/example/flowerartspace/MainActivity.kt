package com.example.flowerartspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.flowerartspace.model.FlowersList
import com.example.flowerartspace.ui.theme.FlowerArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlowerArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FlowerArtSpaceApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlowerArtSpaceApp() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp),
        topBar = {
            TopAppBar()
        }
    ) {
        FlowerView(Modifier.padding(it))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(text = stringResource(R.string.app_name))
        },
        modifier = modifier,
    )
}

@Composable
fun FlowerView(modifier: Modifier = Modifier) {
    var number by remember {
        mutableStateOf(0)
    }
    val flower = FlowersList.flowers[number]
    val flowersLength = FlowersList.flowers.size - 1
    val previous = {
        number--
        if (number < 0) number = flowersLength
    }
    val next = {
        number++
        if (number > flowersLength) number = 0
    }
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(top = 44.dp, bottom = 44.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
            modifier = Modifier
                .padding(48.dp)
                .height(288.dp)
        ) {
            Image(
                painter = painterResource(flower.imageResourceId),
                contentDescription = null,
                modifier = Modifier.fillMaxHeight(),
            )
        }
        Row(modifier = modifier) {
           Column(
               horizontalAlignment = Alignment.CenterHorizontally
           ) {
               Text(
                   text = stringResource(flower.nameResourceId)
               )
               Text(
                   text = stringResource(flower.lifeCycleResourceId)
               )
           }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 48.dp,
                    end = 48.dp
                )
        ) {
            Button(
                onClick = previous,
                modifier = Modifier.width(120.dp)
            ) {
                Text(text = stringResource(R.string.previous))
            }
            Button(
                onClick = next,
                modifier = Modifier.width(120.dp)
            ) {
                Text(text = stringResource(R.string.next))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    FlowerArtSpaceTheme {
        FlowerArtSpaceApp()
    }
}
