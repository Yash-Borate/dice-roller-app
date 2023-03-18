package com.example.dicerollerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dicerollerapp.ui.theme.DiceRollerAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DiceRoller()
                }
            }
        }
    }
}
@Preview
@Composable
fun DiceRoller(){
diceRollWithImage(modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center))
}

@Composable
fun diceRollWithImage(modifier: Modifier=Modifier){

    var result by remember { mutableStateOf(1) }

    val imageR = when(result){
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_1
    }

    Column(modifier = modifier , horizontalAlignment = Alignment.CenterHorizontally)  {
        Image(painter = painterResource(id = imageR), contentDescription ="null" )

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = { result = (1..6).random()}) {
            Text(
                text = stringResource(id = R.string.roll),
                fontSize = 24.sp,
                modifier = Modifier.width(80.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}
