package com.example.lemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonadeapp.ui.theme.LemonadeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center),
                    color = MaterialTheme.colors.background
                ) {
                    InstructionWithImage()
                }
            }
        }
    }
}

@Composable
fun InstructionWithImage(modifier: Modifier = Modifier) {
    var result: Int by remember {
        mutableStateOf(1)
    }

    val imageResource = when (result) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    val instructionResource = when (result) {
        1 -> R.string.instruction_1
        2 -> R.string.instruction_2
        3 -> R.string.instruction_3
        else -> R.string.instruction_4
    }

    val contentResource = when (result) {
        1 -> R.string.lemon_tree_description
        2 -> R.string.lemon_content_description
        3 -> R.string.lemonade_content_description
        else -> R.string.glass_content_description
    }

    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = stringResource(instructionResource), fontSize = 18.sp)
        Spacer(modifier = modifier.height(16.dp))
        OutlinedButton(
            onClick = {
                if (result in 1..3) {
                    result += 1
                } else {
                    result = 1
                }
            },
            border = BorderStroke(2.dp, Color(105, 205, 216)),
            shape = RoundedCornerShape(2),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(105, 205, 216))
        ) {
            Image(
                painter = painterResource(imageResource),
                contentDescription = stringResource(contentResource)
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeAppTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center),
            color = MaterialTheme.colors.background
        ) {
            InstructionWithImage()
        }
    }
}