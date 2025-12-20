package tt.co.jesses.treeswings

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tt.co.jesses.treeswings.ui.theme.TreeSwingsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TreeSwingsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TreeSwingsApp()
                }
            }
        }
    }
}

@Composable
fun TreeSwingsApp() {
    val swings = listOf(
        "Oak Tree Swing",
        "Backyard Tire Swing",
        "Park Bench Swing",
        "River Rope Swing"
    )

    LazyColumn(modifier = Modifier.padding(16.dp)) {
        item {
            Text(
                text = "My Tree Swings",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
        items(swings) { swing ->
            SwingItem(name = swing)
        }
    }
}

@Composable
fun SwingItem(name: String) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = name,
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TreeSwingsAppPreview() {
    TreeSwingsTheme {
        TreeSwingsApp()
    }
}
