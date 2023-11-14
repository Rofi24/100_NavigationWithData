package com.example.esjumbo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.esjumbo.ui.theme.EsJumboTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanForm(
    onSubmitButtonClick: (MutableList<String>) -> Unit,
    onCancelButtonClick: () -> Unit
){
    var namaTxt by rememberSaveable {
        mutableStateOf("")
    }

    var alamatTxt by rememberSaveable {
        mutableStateOf("")
    }

    var telponTxt by rememberSaveable {
        mutableStateOf("")
    }

    var listDataTxt : MutableList<String> = mutableListOf(namaTxt, alamatTxt, telponTxt)

    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ){
        OutlinedTextField(value = namaTxt, onValueChange = {
            namaTxt = it
        }, label = {
            Text(text = "Nama")
        },

            )
        OutlinedTextField(value = alamatTxt, onValueChange = {
            alamatTxt = it
        }, label = {
            Text(text = "Alamat")
        }
        )
        OutlinedTextField(value = telponTxt, onValueChange = {
            telponTxt = it
        }, label = {
            Text(text = "Telpon")
        }
        )
        Spacer(modifier = Modifier.padding(16.dp))

        Button(onClick = { onCancelButtonClick() }) {
            Text(text = "Batal")
        }

        Button(onClick = { onSubmitButtonClick(listDataTxt) }) {
            Text(text = stringResource(R.string.btn_submit))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHalamanHome() {
    EsJumboTheme {
        HalamanForm(onSubmitButtonClick= {}, onCancelButtonClick =  {})
    }
}