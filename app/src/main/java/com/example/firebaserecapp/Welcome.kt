package com.example.firebaserecapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.firebaserecapp.ui.theme.FirebaseRecappTheme

class Welcome : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirebaseRecappTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    CartNav()
                }
            }
        }
    }
}

@Composable
fun CartNav(modifier : Modifier = Modifier) {
    val context = LocalContext.current
    NavigationBar(modifier = modifier,
        containerColor = MaterialTheme.colorScheme.surfaceVariant
    ) {
        NavigationBarItem(
            selected = false
            , onClick = {
                context.startActivity(Intent(context,MainActivity::class.java))
            },
            label = {
                Text(text = "Home")
            },
            icon = {
                Icon(imageVector = Icons.Default.Home , contentDescription =null )
            })
        NavigationBarItem(selected = false ,
            onClick = { /*TODO*/ } ,
            label = {
                Text(text = "favorites")
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Favorite ,
                    contentDescription = null)
            })
        NavigationBarItem(
            selected = true ,
            onClick = { /*TODO*/ } ,
            label = {
                Text(text = "Cart")
            },
            icon = {
                Icon(
                    imageVector =  Icons.Default.ShoppingCart,
                    contentDescription = null)
            })
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FirebaseRecappTheme {
        CartNav()
    }
}