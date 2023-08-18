package com.example.calculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.calculator.databinding.FragmentCalculatorBinding

class Calculator : Fragment() {
    private lateinit var binding: FragmentCalculatorBinding
    private val dataModel: DataModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCalculatorBinding.inflate(inflater)

        // Реализация функционала кнопок
        binding.apply {

            // Portrait buttons
            bZero.setOnClickListener {
                try {
                    if(tvResult.text != "") {
                        tvResult.append(bZero.text)
                        tvPreResult.text = Eval.eval(tvResult.text.toString()).toString()
                        dataModel.calcResult.value = tvResult.text.toString()
                    }
                } catch (e : Exception) {
                    tvPreResult.text = resources.getText(R.string.preResult_erroe)
                }
            }
            bOne.setOnClickListener {
                try {
                    tvResult.append(bOne.text)
                    tvPreResult.text = Eval.eval(tvResult.text.toString()).toString()
                    dataModel.calcResult.value = tvResult.text.toString()
                } catch (e : Exception) {
                    tvPreResult.text = resources.getText(R.string.preResult_erroe)
                }
            }
            bTwo.setOnClickListener {
                try {
                    tvResult.append(bTwo.text)
                    tvPreResult.text = Eval.eval(tvResult.text.toString()).toString()
                    dataModel.calcResult.value = tvResult.text.toString()
                } catch (e : Exception){
                    tvPreResult.text = resources.getText(R.string.preResult_erroe)
                }
            }
            bThree.setOnClickListener {
                try {
                    tvResult.append(bThree.text)
                    tvPreResult.text = Eval.eval(tvResult.text.toString()).toString()
                    dataModel.calcResult.value = tvResult.text.toString()
                } catch (e : Exception){
                    tvPreResult.text = resources.getText(R.string.preResult_erroe)
                }
            }
            bFour.setOnClickListener {
                try {
                    tvResult.append(bFour.text)
                    tvPreResult.text = Eval.eval(tvResult.text.toString()).toString()
                    dataModel.calcResult.value = tvResult.text.toString()
                } catch (e : Exception){
                    tvPreResult.text = resources.getText(R.string.preResult_erroe)
                }
            }
            bFive.setOnClickListener {
                try {
                    tvResult.append(bFive.text)
                    tvPreResult.text = Eval.eval(tvResult.text.toString()).toString()
                    dataModel.calcResult.value = tvResult.text.toString()
                } catch (e : Exception){
                    tvPreResult.text = resources.getText(R.string.preResult_erroe)
                }
            }
            bSix.setOnClickListener {
                try {
                    tvResult.append(bSix.text)
                    tvPreResult.text = Eval.eval(tvResult.text.toString()).toString()
                    dataModel.calcResult.value = tvResult.text.toString()
                } catch (e : Exception){
                    tvPreResult.text = resources.getText(R.string.preResult_erroe)
                }
            }
            bSeven.setOnClickListener {
                try {
                    tvResult.append(bSeven.text)
                    tvPreResult.text = Eval.eval(tvResult.text.toString()).toString()
                    dataModel.calcResult.value = tvResult.text.toString()
                } catch (e : Exception){
                    tvPreResult.text = resources.getText(R.string.preResult_erroe)
                }
            }
            bEight.setOnClickListener {
                try {
                    tvResult.append(bEight.text)
                    tvPreResult.text = Eval.eval(tvResult.text.toString()).toString()
                    dataModel.calcResult.value = tvResult.text.toString()
                } catch (e : Exception){
                    tvPreResult.text = resources.getText(R.string.preResult_erroe)
                }
            }
            bNine.setOnClickListener {
                try {
                    tvResult.append(bNine.text)
                    tvPreResult.text = Eval.eval(tvResult.text.toString()).toString()
                    dataModel.calcResult.value = tvResult.text.toString()
                } catch (e : Exception){
                    tvPreResult.text = resources.getText(R.string.preResult_erroe)
                }
            }
            bDelete.setOnClickListener {
                try {
                    if(tvResult.length() != 0) tvResult.text = tvResult.text.substring(0, tvResult.length() - 1)
                    else tvResult.text = ""
                    tvPreResult.text = Eval.eval(tvResult.text.toString()).toString()
                    dataModel.calcResult.value = tvResult.text.toString()
                } catch (e : Exception){
                    tvPreResult.text = resources.getText(R.string.preResult_erroe)
                }
            }
            bDelete.setOnLongClickListener {
                try {
                    tvResult.text = ""
                    tvPreResult.text = tvResult.text
                    dataModel.calcResult.value = tvResult.text.toString()
                } catch (e : Exception){
                    tvPreResult.text = resources.getText(R.string.preResult_erroe)
                }
                true
            }
            bCancel.setOnClickListener{
                try {
                    tvResult.text = ""
                    tvPreResult.text = tvResult.text
                    dataModel.calcResult.value = tvResult.text.toString()
                } catch (e : Exception){
                    tvPreResult.text = resources.getText(R.string.preResult_erroe)
                }
            }
            bDivide.setOnClickListener {
                if (checkFactor()) tvResult.text = tvResult.text.substring(0, tvResult.text.length - 1)
                tvResult.append("/")
                dataModel.calcResult.value = tvResult.text.toString()
            }
            bMultiply.setOnClickListener {
                if (checkFactor()) tvResult.text = tvResult.text.substring(0, tvResult.text.length - 1)
                tvResult.append("*")
                dataModel.calcResult.value = tvResult.text.toString()
            }
            bMinus.setOnClickListener{
                if (checkFactor()) tvResult.text = tvResult.text.substring(0, tvResult.text.length - 1)
                tvResult.append(bMinus.text)
                dataModel.calcResult.value = tvResult.text.toString()
            }
            bPlus.setOnClickListener {
                if (checkFactor()) tvResult.text = tvResult.text.substring(0, tvResult.text.length - 1)
                tvResult.append(bPlus.text)
                dataModel.calcResult.value = tvResult.text.toString()
            }
            bPercent.setOnClickListener{
                try {
                    tvResult.append(bPercent.text)
                    tvPreResult.text = (tvResult.text.substring(0, tvResult.text.length - 1).toDouble() / 100).toString()
                    dataModel.calcResult.value = tvResult.text.toString()
                } catch (e : Exception){
                    tvPreResult.text = resources.getText(R.string.preResult_erroe)
                }
            }
            bDot.setOnClickListener {
                try {
                    tvResult.append(bDot.text)
                    dataModel.calcResult.value = tvResult.text.toString()
                } catch (e : Exception){
                    tvPreResult.text = resources.getText(R.string.preResult_erroe)
                }
            }
            bEqual.setOnClickListener {
                if (tvPreResult.text.isEmpty() && tvResult.text.isNotEmpty()) {
                    if (tvResult.text.endsWith("!")) tvResult.text = Eval.fact(tvResult.text.substring(0, tvResult.text.length - 1).toInt()).toString()
                    else if (tvResult.text.endsWith("%")) tvResult.text = (tvResult.text.substring(0, tvResult.text.length - 1).toDouble() / 100).toString()
                    else tvResult.text = Eval.eval(tvResult.text.toString()).toString()
                    dataModel.calcResult.value = tvResult.text.toString()
                }
                else if (tvPreResult.text.toString() != resources.getText(R.string.preResult_erroe)) {
                    tvResult.text = tvPreResult.text
                    tvPreResult.text = ""
                    dataModel.calcResult.value = tvResult.text.toString()
                }
                else {
                    tvResult.text = ""
                    tvPreResult.text = ""
                    dataModel.calcResult.value = tvResult.text.toString()
                }

            }

            // Landscape buttons
            bLeftBracket?.setOnClickListener {
                tvResult.append(bLeftBracket.text)
                dataModel.calcResult.value = tvResult.text.toString()
            }
            bRightBracket?.setOnClickListener {
                tvResult.append(bRightBracket.text)
                dataModel.calcResult.value = tvResult.text.toString()
            }
            bOneDivideX?.setOnClickListener {
                try {
                    if (checkFactor()) tvResult.text = tvResult.text.substring(0, tvResult.text.length - 1)
                    tvResult.append("^(-1)")
                    tvPreResult.text = Eval.eval(tvResult.text.toString()).toString()
                    dataModel.calcResult.value = tvResult.text.toString()
                } catch (e : Exception){
                    tvPreResult.text = resources.getText(R.string.preResult_erroe)
                }
            }
            bDegreeTwo?.setOnClickListener {
                try {
                    if (checkFactor()) tvResult.text = tvResult.text.substring(0, tvResult.text.length - 1)
                    tvResult.append("^(2)")
                    tvPreResult.text = Eval.eval(tvResult.text.toString()).toString()
                    dataModel.calcResult.value = tvResult.text.toString()
                } catch (e : Exception){
                    tvPreResult.text = resources.getText(R.string.preResult_erroe)
                }
            }
            bDegreeThree?.setOnClickListener {
                try {
                    if (checkFactor()) tvResult.text = tvResult.text.substring(0, tvResult.text.length - 1)
                    tvResult.append("^(3)")
                    tvPreResult.text = Eval.eval(tvResult.text.toString()).toString()
                    dataModel.calcResult.value = tvResult.text.toString()
                } catch (e : Exception){
                    tvPreResult.text = resources.getText(R.string.preResult_erroe)
                }
            }
            bDegreeY?.setOnClickListener {
                try {
                    if (checkFactor()) tvResult.text = tvResult.text.substring(0, tvResult.text.length - 1)
                    tvResult.append("^(")
                    dataModel.calcResult.value = tvResult.text.toString()
                } catch (e : Exception){
                    tvPreResult.text = resources.getText(R.string.preResult_erroe)
                }
            }
            bFactorial?.setOnClickListener {
                try {
                    if (checkFactor()) tvResult.text = tvResult.text.substring(0, tvResult.text.length - 1)
                    tvResult.append("!")
                    val numbers : String = tvResult.text.substring(0, tvResult.text.length - 1)
                    tvPreResult.text = Eval.fact(Eval.eval(numbers).toInt()).toString()
                    dataModel.calcResult.value = tvResult.text.toString()
                } catch (e : Exception){
                    tvPreResult.text = resources.getText(R.string.preResult_erroe)
                }
            }
            bSqrRoot?.setOnClickListener {
                try {
                    if (checkFactor()) tvResult.text = tvResult.text.substring(0, tvResult.text.length - 1)
                    tvResult.append("^(1/2)")
                    tvPreResult.text = Eval.eval(tvResult.text.toString()).toString()
                    dataModel.calcResult.value = tvResult.text.toString()
                } catch (e : Exception){
                    tvPreResult.text = resources.getText(R.string.preResult_erroe)
                }
            }
            bLog?.setOnClickListener {
                try {
                    if (checkFactor() || tvResult.text.isEmpty()) tvResult.append("log(")
                    else tvResult.append("*log(")
                    dataModel.calcResult.value = tvResult.text.toString()
                } catch (e : Exception){
                    tvPreResult.text = resources.getText(R.string.preResult_erroe)
                }
            }
            bPI?.setOnClickListener {
                try {
                    if (checkFactor() || tvResult.text.isEmpty() || tvResult.text.endsWith("(")) tvResult.append(Math.PI.toString())
                    else tvResult.append("*" + Math.PI.toString())
                    tvPreResult.text = Eval.eval(tvResult.text.toString().replace(bPI.text.toString(), Math.PI.toString())).toString()
                    dataModel.calcResult.value = tvResult.text.toString()
                } catch (e : Exception){
                    tvPreResult.text = resources.getText(R.string.preResult_erroe)
                }
            }
            bE?.setOnClickListener {
                try {
                    if (checkFactor() || tvResult.text.isEmpty() || tvResult.text.endsWith("(")) tvResult.append(Math.E.toString())
                    else tvResult.append("*" + Math.E.toString())
                    tvPreResult.text = Eval.eval(tvResult.text.toString().replace(bE.text.toString(), Math.E.toString())).toString()
                    dataModel.calcResult.value = tvResult.text.toString()
                } catch (e : Exception){
                    tvPreResult.text = resources.getText(R.string.preResult_erroe)
                }
            }
            bLn?.setOnClickListener {
                try {
                    if (checkFactor() || tvResult.text.isEmpty() || tvResult.text.endsWith("(")) tvResult.append("ln(")
                    else tvResult.append("*ln(")
                    dataModel.calcResult.value = tvResult.text.toString()
                } catch (e : Exception){
                    tvPreResult.text = resources.getText(R.string.preResult_erroe)
                }
            }
            bCos?.setOnClickListener {
                try {
                    if (checkFactor() || tvResult.text.isEmpty() || tvResult.text.endsWith("(")) tvResult.append("cos(")
                    else tvResult.append("*cos(")
                    dataModel.calcResult.value = tvResult.text.toString()
                } catch (e : Exception){
                    tvPreResult.text = resources.getText(R.string.preResult_erroe)
                }
            }
            bSin?.setOnClickListener {
                try {
                    if (checkFactor() || tvResult.text.isEmpty() || tvResult.text.endsWith("(")) tvResult.append("sin(")
                    else tvResult.append("*sin(")
                    dataModel.calcResult.value = tvResult.text.toString()
                } catch (e : Exception){
                    tvPreResult.text = resources.getText(R.string.preResult_erroe)
                }
            }
            bTg?.setOnClickListener {
                try {
                    if (checkFactor() || tvResult.text.isEmpty() || tvResult.text.endsWith("(")) tvResult.append("tan(")
                    else tvResult.append("*tan(")
                    dataModel.calcResult.value = tvResult.text.toString()
                } catch (e : Exception){
                    tvPreResult.text = resources.getText(R.string.preResult_erroe)
                }

            }

            dataModel.calcResult.observe(this@Calculator) {
                tvResult.text = dataModel.calcResult.value
            }
        }
        return binding.root
    }

    private fun checkFactor() : Boolean  {
        return binding.tvResult.text.endsWith("/") ||
            binding.tvResult.text.endsWith("-") ||
            binding.tvResult.text.endsWith("*") ||
            binding.tvResult.text.endsWith("+")
    }



    companion object {
        @JvmStatic
        fun newInstance() = Calculator()
    }


}




