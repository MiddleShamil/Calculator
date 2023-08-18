package com.example.calculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.calculator.databinding.FragmentMenuQuantitiesBinding


class MenuQuantities : Fragment() {
    private lateinit var binding: FragmentMenuQuantitiesBinding
    private val dataModel: DataModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuQuantitiesBinding.inflate(inflater)

        binding.apply {
            tvLength.setOnClickListener { goToQuantitiesFrag(R.array.length) }
            tvMass.setOnClickListener { goToQuantitiesFrag(R.array.mass)}
            tvVolume.setOnClickListener { goToQuantitiesFrag(R.array.volume)}
            tvArea.setOnClickListener {  goToQuantitiesFrag(R.array.area)}
            tvNumberSystem.setOnClickListener { goToQuantitiesFrag(R.array.number_systems) }
        }

        return binding.root
    }


    companion object {
        @JvmStatic
        fun newInstance() = MenuQuantities()
    }

    private fun goToQuantitiesFrag(r: Int) {
        val nextFrag = Quantities()
        dataModel.entry.value = r
        dataModel.fragment.value = nextFrag
    }

}