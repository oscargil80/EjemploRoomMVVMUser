package com.oscargil80.exampleroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.NavController
import androidx.navigation.ui.*

import com.oscargil80.exampleroom.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //Primer ejemplo de rrom que me dio de cabeza pero lo hice
    //El archivo se llama Exampleroom en la carpeta androisproyets

    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupActionBarWithNavController(findNavController(R.id.fragment))
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}