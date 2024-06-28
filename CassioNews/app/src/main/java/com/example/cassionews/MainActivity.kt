package com.example.cassionews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cassionews.ui.theme.CassioNewsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CassioNewsTheme {
                MaterialTheme(typography = Typography) {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        AppNavigation()
                    }
                }
            }
        }
    }
}

val Jost = FontFamily(
    Font(R.font.jost_regular, FontWeight.Normal),
    Font(R.font.jost_medium, FontWeight.Medium),
    Font(R.font.jost_bold, FontWeight.Bold)
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = Jost,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)
val RegularJostTextStyle = TextStyle(
    fontFamily = Jost,
    fontWeight = FontWeight.Normal,
    fontSize = 18.sp
)
val BoldJostTextStyle = TextStyle(
    fontFamily = Jost,
    fontWeight = FontWeight.Bold,
    fontSize = 40.sp
)

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("noticia1") { Noticia1Screen() }
        composable("noticia2") { Noticia2Screen() }
        composable("noticia3") { Noticia3Screen() }
    }
}

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
    ) {
        Row(
            Modifier
                .height(150.dp)
                .fillMaxWidth()
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFF30107A),
                            Color(0xFFA739C0)
                        )
                    )
                ),Arrangement.Center
        ) {
            Column(
                Modifier
                    .padding(40.dp),
            ) {
                Row(
                    Modifier
                        .fillMaxWidth(),
                    Arrangement
                        .Start
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "Logo",
                        modifier = Modifier.size(200.dp)
                    )
                    Text(
                        text = "News",
                        fontSize = 40.sp,
                        color = Color(0xFFFFFFFF),
                        style = BoldJostTextStyle,
                        modifier = Modifier
                            .padding(start = 0.dp)
                            .offset(x = (-12).dp)
                            .align(Alignment.CenterVertically)
                    )
                }
            }
        }
        Column(
            Modifier
                .fillMaxSize()
                .background(Color(0xFFFFFFFF)),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 6.dp)
            ) {
                NoticiaItem(
                    navController = navController,
                    titulo = "Câmara aprova projeto que reconhece Campinas como capital nacional da ciência, tecnologia e inovação - Notícias",
                    imagem = R.drawable.not1,
                    rota = "noticia1"
                )
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 6.dp)
            ) {
                NoticiaItem(
                    navController = navController,
                    titulo = "10 notícias de tecnologia para você começar o da (26/06)",
                    imagem = R.drawable.not2,
                    rota = "noticia2"
                )
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 6.dp)
            ) {
                NoticiaItem(
                    navController = navController,
                    titulo = "10 notícias de tecnologia para você começar o da (27/06)",
                    imagem = R.drawable.not3,
                    rota = "noticia3"
                )
            }
        }
    }
}

@Composable
fun NoticiaItem(navController: NavController, titulo: String, imagem: Int, rota: String) {
    Row(
        modifier = Modifier
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xFF30107A),
                        Color(0xFFA739C0)
                    )
                ),
                shape = RoundedCornerShape(10.dp)
            )
            .width(380.dp)
            .height(180.dp)
            .clickable { navController.navigate(rota) }
    ) {
        Image(
            painter = painterResource(id = imagem),
            contentDescription = "Noticia",
            modifier = Modifier
                .size(150.dp)
                .padding(start = 0.dp)
                .offset(x = (12).dp)
                .align(Alignment.CenterVertically)
                .clip(RoundedCornerShape(10.dp)),
            contentScale = ContentScale.Crop
        )
        Text(
            text = titulo,
            fontSize = 18.sp,
            color = Color(0xFFFFFFFF),
            style = RegularJostTextStyle,
            modifier = Modifier
                .padding(start = 0.dp)
                .width(200.dp)
                .offset(x = (25).dp)
                .align(Alignment.CenterVertically)
        )
    }
}

@Composable
fun Noticia1Screen() {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
    ) {
        Row(
            Modifier
                .height(150.dp)
                .fillMaxWidth()
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFF30107A),
                            Color(0xFFA739C0)
                        )
                    )
                ), Arrangement.Center
        ) {
            Column(
                Modifier
                    .padding(40.dp),
            ) {
                Row(
                    Modifier
                        .fillMaxWidth(),
                    Arrangement
                        .Start
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "Logo",
                        modifier = Modifier.size(200.dp)
                    )
                    Text(
                        text = "News",
                        fontSize = 40.sp,
                        color = Color(0xFFFFFFFF),
                        style = BoldJostTextStyle,
                        modifier = Modifier
                            .padding(start = 0.dp)
                            .offset(x = (-12).dp)
                            .align(Alignment.CenterVertically),
                    )
                }
            }
        }
        Column(
            Modifier
                .fillMaxSize()
                .background(Color(0xFFFFFFFF)),
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .padding(top = 10.dp),
                Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.not1),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .width(380.dp)
                        .align(Alignment.CenterVertically)
                        .clip(RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.Crop
                )
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(10.dp),
                Arrangement.Center
            ) {
            }
            Row(
                Modifier
                    .fillMaxWidth(),
                Arrangement.Center
            ) {
                Text(
                    text = "Câmara aprova projeto que reconhece Campinas como capital nacional da ciência, tecnologia e inovação",
                    fontSize = 22.sp,
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Center,
                    style = BoldJostTextStyle,
                    modifier = Modifier
                        .padding(start = 0.dp)
                        .width(380.dp)
                        .align(Alignment.CenterVertically)
                )
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(10.dp),
                Arrangement.Center
            ) {
            }
            Row(
                Modifier
                    .fillMaxWidth(),
                Arrangement.Center
            ) {
                Text(
                    text = "A Câmara dos Deputados aprovou o Projeto de Lei 3680/23, que confere ao município de Campinas (SP) o título de capital nacional da ciência, tecnologia e inovação. A proposta será enviada ao Senado.\n" +
                            "\n" +
                            "Segundo o autor do projeto, deputado Jonas Donizette (PSB-SP), Campinas tem o maior ecossistema nacional de pesquisa, desenvolvimento e inovação do Brasil, formado por indústrias de base tecnológica, centros de pesquisa e universidades, além de quatro parques tecnológicos.\n" +
                            "\n" +
                            "Fonte: Agência Câmara de Notícias",
                    fontSize = 15.sp,
                    color = Color(0xFF000000),
                    style = RegularJostTextStyle,
                    modifier = Modifier
                        .padding(start = 0.dp)
                        .width(350.dp)
                        .align(Alignment.CenterVertically)
                )
            }
        }
    }
}

@Composable
fun Noticia2Screen() {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
    ) {
        Row(
            Modifier
                .height(150.dp)
                .fillMaxWidth()
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFF30107A),
                            Color(0xFFA739C0)
                        )
                    )
                ), Arrangement.Center
        ) {
            Column(
                Modifier
                    .padding(40.dp),
            ) {
                Row(
                    Modifier
                        .fillMaxWidth(),
                    Arrangement
                        .Start
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "Logo",
                        modifier = Modifier.size(200.dp)
                    )
                    Text(
                        text = "News",
                        fontSize = 40.sp,
                        color = Color(0xFFFFFFFF),
                        style = BoldJostTextStyle,
                        modifier = Modifier
                            .padding(start = 0.dp)
                            .offset(x = (-12).dp)
                            .align(Alignment.CenterVertically),
                    )
                }
            }
        }
        Column(
            Modifier
                .fillMaxSize()
                .background(Color(0xFFFFFFFF)),
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .padding(top = 10.dp),
                Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.not2),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .width(380.dp)
                        .align(Alignment.CenterVertically)
                        .clip(RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.Crop
                )
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(10.dp),
                Arrangement.Center
            ) {
            }
            Row(
                Modifier
                    .fillMaxWidth(),
                Arrangement.Center
            ) {
                Text(
                    text = "10 notícias de tecnologia para você começar o da (26/06)",
                    fontSize = 22.sp,
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Center,
                    style = BoldJostTextStyle,
                    modifier = Modifier
                        .padding(start = 0.dp)
                        .width(380.dp)
                        .align(Alignment.CenterVertically)
                )
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(10.dp),
                Arrangement.Center
            ) {
            }
            Row(
                Modifier
                    .fillMaxWidth(),
                Arrangement.Center
            ) {
                Text(
                    text = "Bom dia! Separamos as principais notícias do mundo da Ciência e Tecnologia para você saber tudo o que aconteceu na última terça-feira (25). Para conferir cada notícia na íntegra, basta clicar nos links a seguir."+
                    "\n\n1. Amazon divulga as datas do Prime Day 2024; confira. O Amazon Prime Day acontecerá no mês de julho."+
                    "\n\n2. Qual é o segredo de Riley em Divertida Mente 2? Entenda cena pós-creditos. A cena pós-créditos de Divertida Mente 2 faz uma revelação importante sobre Riley, porém, não foi o que muitos fãs esperavam. Entenda!",
                    fontSize = 15.sp,
                    color = Color(0xFF000000),
                    style = RegularJostTextStyle,
                    modifier = Modifier
                        .padding(start = 0.dp)
                        .width(350.dp)
                        .align(Alignment.CenterVertically)
                )
            }
        }
    }
}

@Composable
fun Noticia3Screen() {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
    ) {
        Row(
            Modifier
                .height(150.dp)
                .fillMaxWidth()
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFF30107A),
                            Color(0xFFA739C0)
                        )
                    )
                ), Arrangement.Center
        ) {
            Column(
                Modifier
                    .padding(40.dp),
            ) {
                Row(
                    Modifier
                        .fillMaxWidth(),
                    Arrangement
                        .Start
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "Logo",
                        modifier = Modifier.size(200.dp)
                    )
                    Text(
                        text = "News",
                        fontSize = 40.sp,
                        color = Color(0xFFFFFFFF),
                        style = BoldJostTextStyle,
                        modifier = Modifier
                            .padding(start = 0.dp)
                            .offset(x = (-12).dp)
                            .align(Alignment.CenterVertically),
                    )
                }
            }
        }
        Column(
            Modifier
                .fillMaxSize()
                .background(Color(0xFFFFFFFF)),
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .padding(top = 10.dp),
                Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.not3),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .width(380.dp)
                        .align(Alignment.CenterVertically)
                        .clip(RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.Crop
                )
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(10.dp),
                Arrangement.Center
            ) {
            }
            Row(
                Modifier
                    .fillMaxWidth(),
                Arrangement.Center
            ) {
                Text(
                    text = "10 notícias de tecnologia para você começar o da (27/06)",
                    fontSize = 22.sp,
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Center,
                    style = BoldJostTextStyle,
                    modifier = Modifier
                        .padding(start = 0.dp)
                        .width(380.dp)
                        .align(Alignment.CenterVertically)
                )
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(10.dp),
                Arrangement.Center
            ) {
            }
            Row(
                Modifier
                    .fillMaxWidth(),
                Arrangement.Center
            ) {
                Text(
                    text = "Bom dia! Separamos as principais notícias do mundo da Ciência e Tecnologia para você saber tudo o que aconteceu na última quarta-feira (26). Para conferir cada notícia na íntegra, basta clicar nos links a seguir."+
                            "\n\n1. Julho na Netflix: confira as principais estreias do mês no streaming. Julho terá várias estreias aguardadas na Netflix, incluindo as novas temporadas de Elite, Cobra Kai, Sweet Home e Vikings: Valhalla!"+
                            "\n\n2. Físicos descobrem por acaso uma nova forma de representar o Pi. Tentando simplificar a forma de calcular o espalhamento quântico de partículas, dois físicos criaram acidentalmente uma nova representação em série para o Pi.",
                    fontSize = 15.sp,
                    color = Color(0xFF000000),
                    style = RegularJostTextStyle,
                    modifier = Modifier
                        .padding(start = 0.dp)
                        .width(350.dp)
                        .align(Alignment.CenterVertically)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CassioNewsTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            AppNavigation()
        }
    }
}