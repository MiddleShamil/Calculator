package com.example.calculator

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import com.example.calculator.databinding.FragmentQuantitiesBinding
import kotlin.math.roundToInt

class Quantities : Fragment() {
    lateinit var binding: FragmentQuantitiesBinding
    private val dataModel: DataModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuantitiesBinding.inflate(inflater)

        activity!!.findViewById<LinearLayout>(R.id.linearLayout)
            .setBackgroundColor(ContextCompat.getColor(requireActivity().baseContext, R.color.background_quantities))

        binding.apply {
            bEqualQuantities.setOnClickListener {
                calc()
                bEqualQuantities.hidekeyboard()
            }
            editTextFirstQuantity.setOnFocusChangeListener { _, hasFocus ->
                if(!hasFocus) editTextFirstQuantity.hidekeyboard()
            }

            editTextSecondQuantity.setOnFocusChangeListener { _, hasFocus ->
                if (!hasFocus) editTextSecondQuantity.hidekeyboard()
            }
        }



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setEntry(dataModel.entry.value!!)
    }

    private fun calc() {
        binding.apply {
            if (editTextFirstQuantity.text.toString().isEmpty() && editTextSecondQuantity.text.toString().isEmpty()) {
            Toast.makeText(activity, getString(R.string.warning_empty), Toast.LENGTH_SHORT).show()
        }  else if (editTextFirstQuantity.text.toString().isNotEmpty()) {
            when (firstSpinner.adapter.count)  {
                9 -> editTextSecondQuantity.setText(Functions.Length.count(
                    firstSpinner.selectedItemId.toInt(),
                    secondSpinner.selectedItemId.toInt(),
                    round(editTextFirstQuantity.text.toString().toDouble())
                ).toString())
                6 -> editTextSecondQuantity.setText(Functions.Volume.count(
                    firstSpinner.selectedItemId.toInt(),
                    secondSpinner.selectedItemId.toInt(),
                    round(editTextFirstQuantity.text.toString().toDouble())
                ).toString())
                8 -> editTextSecondQuantity.setText(Functions.Mass.count(
                    firstSpinner.selectedItemId.toInt(),
                    secondSpinner.selectedItemId.toInt(),
                    round(editTextFirstQuantity.text.toString().toDouble())
                ).toString())
                12 -> editTextSecondQuantity.setText(Functions.Area.count(
                    firstSpinner.selectedItemId.toInt(),
                    secondSpinner.selectedItemId.toInt(),
                    round(editTextFirstQuantity.text.toString().toDouble())
                ).toString())
                4 -> editTextSecondQuantity.setText(Functions.NumberSystem.count(
                    firstSpinner.selectedItemId.toInt(),
                    secondSpinner.selectedItemId.toInt(),
                    round(editTextFirstQuantity.text.toString().toDouble())
                ).toString())


            }
        } else {
            when (secondSpinner.adapter.count) {
                9 -> editTextFirstQuantity.setText(Functions.Length.count(
                    firstSpinner.selectedItemId.toInt(),
                    secondSpinner.selectedItemId.toInt(),
                    round(editTextSecondQuantity.text.toString().toDouble())
                ).toString())
                6 -> editTextFirstQuantity.setText(Functions.Volume.count(
                    firstSpinner.selectedItemId.toInt(),
                    secondSpinner.selectedItemId.toInt(),
                    round(editTextSecondQuantity.text.toString().toDouble())
                ).toString())
                8 -> editTextFirstQuantity.setText(Functions.Mass.count(
                    firstSpinner.selectedItemId.toInt(),
                    secondSpinner.selectedItemId.toInt(),
                    round(editTextSecondQuantity.text.toString().toDouble())
                ).toString())
                12 -> editTextFirstQuantity.setText(Functions.Area.count(
                    firstSpinner.selectedItemId.toInt(),
                    secondSpinner.selectedItemId.toInt(),
                    round(editTextSecondQuantity.text.toString().toDouble())
                ).toString())
                4 -> editTextFirstQuantity.setText(Functions.NumberSystem.count(
                    firstSpinner.selectedItemId.toInt(),
                    secondSpinner.selectedItemId.toInt(),
                    round(editTextSecondQuantity.text.toString().toDouble())
                ).toString())
            }

        }
        }
    }

    private fun setEntry(r: Int) {
        val adapter : ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(requireActivity().baseContext, r, R.layout.color_spinner)
        adapter.setDropDownViewResource(R.layout.spinner_dropdown)
        binding.firstSpinner.adapter = adapter
        binding.secondSpinner.adapter = adapter
    }

    private fun View.hidekeyboard() {
        this.clearFocus()
        val inputMethodManager = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(this.windowToken, 0)
    }

    private fun round(number: Double) : Double {
        return (number * 100000).roundToInt().toDouble() / 100000
    }

    companion object {
        @JvmStatic
        fun newInstance() = Quantities()
    }
}