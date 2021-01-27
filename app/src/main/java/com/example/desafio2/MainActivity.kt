package com.example.desafio2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desafio2.adapters.MyRestaurantListAdapter
import com.example.desafio2.databinding.ActivityMainBinding
import com.example.desafio2.model.PlatesModel
import com.example.desafio2.model.RestaurantModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val navController = findNavController(R.id.nav_host_fragment)

    private fun recyclerView(list: List<RestaurantModel>) {
        binding.RVRestaurant.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = MyRestaurantListAdapter(list) {
                val action = MainActivityDirections.activityToFirstFragment(it.id)
                findNavController().navigate(action)
            }
        }
    }

    val oneListPlate = mutableListOf<PlatesModel>()
    val firstPlate = PlatesModel(
        1,
        "https://vejasp.abril.com.br/wp-content/uploads/2016/11/ribsonthebarbie-outback-8-jpg.jpeg",
        "Costelinha com Fritas",
        "Suculenta costela, assada por mais de três horas, coberto com molho barbecue especial e servido com batatas sequinhas e crocantes tempradas com pimenta do reino e sal"
    )
    val secondPlate = PlatesModel(
        2,
        "https://veja.abril.com.br/wp-content/uploads/2017/11/donana-002.jpg",
        "Moqueca de Camarão",
        "Moqueca preparada com leite de coco e dendê, além de outras especiarias"
    )

    val thirdPlate = PlatesModel(
        3,
        "https://duogourmet-images.s3.us-east-2.amazonaws.com/restaurants/5dc53e953ea0f81598899cd1/cover.jpg",
        "Peixe à La Taperia",
        "Peixe cozido e enrolado, temperado com ervas frescas e azeite de oliva"
    )

    val fourthPlate = PlatesModel(
        4,
        "https://i0.wp.com/www.bahiasocialvip.com.br/wp-content/uploads/2020/03/pasta-em-casa.jpg",
        "Ravioli ao Molho de Tomate",
        "Ravioli de espinafre recheado com queijo de cabra e coberto com molho de tomates frescos"
    )

    val myRestaurantList = mutableListOf<RestaurantModel>()
    val restaurantOne = RestaurantModel(
        1,
        "https://vejasp.abril.com.br/wp-content/uploads/2016/11/ribsonthebarbie-outback-8-jpg.jpeg",
        "OutBack",
        "Shopping da Bahia, 2º andar, Salvador - BA",
        "Fecha às 23h",
        oneListPlate
    )
    val restaurantTwo = RestaurantModel(
        2,
        "https://veja.abril.com.br/wp-content/uploads/2017/11/donana-002.jpg",
        "Donana",
        "Av. Brotas, nº 421, Salvador - BA ",
        "Fecha às 17h",
        oneListPlate
    )
    val restaurantThree = RestaurantModel(
        3,
        "https://duogourmet-images.s3.us-east-2.amazonaws.com/restaurants/5dc53e953ea0f81598899cd1/cover.jpg",
        "La Taperia",
        "Av. Oswaldo Cruz, Largo da Mariquita, Salvador - BA",
        "Fecha às 1h",
        oneListPlate
    )
    val restaurantFour = RestaurantModel(
        4,
        "https://i0.wp.com/www.bahiasocialvip.com.br/wp-content/uploads/2020/03/pasta-em-casa.jpg",
        "Pasta em Casa",
        "Av. do Meio, nº 2, Salvador - BA",
        "Fecha às 00:30h",
        oneListPlate
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        oneListPlate.addAll(mutableListOf(firstPlate, secondPlate, thirdPlate, fourthPlate))
        myRestaurantList.addAll(
            listOf(
                restaurantOne,
                restaurantTwo,
                restaurantThree,
                restaurantFour
            )
        )

        recyclerView(myRestaurantList)
    }
}




