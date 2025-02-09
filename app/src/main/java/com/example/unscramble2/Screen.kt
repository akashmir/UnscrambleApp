package com.example.unscramble2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Preview(showBackground = true)
@Composable
fun Screen(
    gameviewmodel: GameViewModel = viewModel()
){


    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ){
        Text(
            text = "Unscramble",
            style = typography.displaySmall
        )
        GameScreen(gameviewmodel)

        Button(
            onClick = {gameviewmodel.checkUserGuess()},
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .padding(8.dp)
            ) {
            Text(text = "Submit")
        }
        OutlinedButton(
            onClick = {gameviewmodel.skipWord()},
            modifier = Modifier
                .fillMaxWidth()

                .padding(8.dp)
        ) {
            Text(text = "Skip")
        }
        Card {
            Text(text = "")
        }
    }

}


@Composable
fun GameScreen(
    gameviewmodel: GameViewModel
) {

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()


    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ){
            Text(
            modifier = Modifier
                .clip(shapes.medium)
                .background(colorScheme.surfaceTint)
                .padding(horizontal = 10.dp, vertical = 4.dp)
                .align(alignment = Alignment.End)
                ,
            text = gameviewmodel.score.toString(),  //score
            style = typography.titleMedium,
            color = colorScheme.onPrimary
        )
            Text(
                text = gameviewmodel.suffledWord,
                style = typography.displayMedium,
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Text(
                text = "Unscramble the word using all the letters.",
                style = typography.labelLarge,
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.CenterHorizontally)
            )
            OutlinedTextField(

                value = gameviewmodel.guess,
                onValueChange = { gameviewmodel.userGuess(it) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = colorScheme.surface,
                    unfocusedContainerColor = colorScheme.surface,
                    disabledContainerColor = colorScheme.surface,
                ),
                label = {
                    Text(text = "Enter your word")

                },



            )
        }
    }
}


