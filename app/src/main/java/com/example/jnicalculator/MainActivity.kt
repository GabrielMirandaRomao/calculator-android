package com.example.jnicalculator

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.jnicalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var firstNumber: String = ""
    private var secondNumber: String = ""
    private var operation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setListener()
    }

    private fun setListener() {
        binding.apply {
            mbtNumber0.setOnClickListener {
                if (operation.isEmpty()) {
                    firstNumber += "0"
                    binding.tvFirstNumber.text = stringFromJNI(firstNumber)
                } else {
                    secondNumber += "0"
                    binding.tvSecondNumber.text = stringFromJNI(secondNumber)
                }
            }
            mbtNumber1.setOnClickListener {
                if (operation.isEmpty()) {
                    firstNumber += "1"
                    binding.tvFirstNumber.text = stringFromJNI(firstNumber)
                } else {
                    secondNumber += "1"
                    binding.tvSecondNumber.text = stringFromJNI(secondNumber)
                }
            }
            mbtNumber2.setOnClickListener {
                if (operation.isEmpty()) {
                    firstNumber += "2"
                    binding.tvFirstNumber.text = stringFromJNI(firstNumber)
                } else {
                    secondNumber += "2"
                    binding.tvSecondNumber.text = stringFromJNI(secondNumber)
                }
            }
            mbtNumber3.setOnClickListener {
                if (operation.isEmpty()) {
                    firstNumber += "3"
                    binding.tvFirstNumber.text = stringFromJNI(firstNumber)
                } else {
                    secondNumber += "3"
                    binding.tvSecondNumber.text = stringFromJNI(secondNumber)
                }
            }
            mbtNumber4.setOnClickListener {
                if (operation.isEmpty()) {
                    firstNumber += "4"
                    binding.tvFirstNumber.text = stringFromJNI(firstNumber)
                } else {
                    secondNumber += "4"
                    binding.tvSecondNumber.text = stringFromJNI(secondNumber)
                }
            }
            mbtNumber5.setOnClickListener {
                if (operation.isEmpty()) {
                    firstNumber += "5"
                    binding.tvFirstNumber.text = stringFromJNI(firstNumber)
                } else {
                    secondNumber += "5"
                    binding.tvSecondNumber.text = stringFromJNI(secondNumber)
                }
            }
            mbtNumber6.setOnClickListener {
                if (operation.isEmpty()) {
                    firstNumber += "6"
                    binding.tvFirstNumber.text = stringFromJNI(firstNumber)
                } else {
                    secondNumber += "6"
                    binding.tvSecondNumber.text = stringFromJNI(secondNumber)
                }
            }
            mbtNumber7.setOnClickListener {
                if (operation.isEmpty()) {
                    firstNumber += "7"
                    binding.tvFirstNumber.text = stringFromJNI(firstNumber)
                } else {
                    secondNumber += "7"
                    binding.tvSecondNumber.text = stringFromJNI(secondNumber)
                }
            }
            mbtNumber8.setOnClickListener {
                if (operation.isEmpty()) {
                    firstNumber += "8"
                    binding.tvFirstNumber.text = stringFromJNI(firstNumber)
                } else {
                    secondNumber += "8"
                    binding.tvSecondNumber.text = stringFromJNI(secondNumber)
                }
            }
            mbtNumber9.setOnClickListener {
                if (operation.isEmpty()) {
                    firstNumber += "9"
                    binding.tvFirstNumber.text = stringFromJNI(firstNumber)
                } else {
                    secondNumber += "9"
                    binding.tvSecondNumber.text = stringFromJNI(secondNumber)
                }
            }
            btEquals.setOnClickListener {
                if (operation.isNotEmpty() && firstNumber.isNotEmpty() && secondNumber.isNotEmpty()) {
                    binding.tvFirstNumber.visibility = View.GONE
                    binding.tvSecondNumber.visibility = View.GONE
                    binding.tvCalculateResult.visibility = View.VISIBLE
                    printOperationResult(operation)
                }
            }
            btClearAll.setOnClickListener {
                secondNumber = ""
                binding.tvSecondNumber.text = ""
                firstNumber = ""
                binding.tvFirstNumber.text = ""
                operation = ""
                binding.tvFirstNumber.visibility = View.VISIBLE
                binding.tvSecondNumber.visibility = View.VISIBLE
                binding.tvCalculateResult.visibility = View.GONE
            }
        }

        binding.apply {
            btAdd.setOnClickListener {
                if (firstNumber.isNotEmpty()) {
                    binding.tvFirstNumber.visibility = View.GONE
                    binding.tvSecondNumber.visibility = View.VISIBLE
                    operation = Constants.ADD
                } else {
                    showToast()
                }
            }
            btMinus.setOnClickListener {
                if (firstNumber.isNotEmpty()) {
                    binding.tvFirstNumber.visibility = View.GONE
                    binding.tvSecondNumber.visibility = View.VISIBLE
                    operation = Constants.MINUS
                }else {
                    showToast()
                }
            }
            btTimes.setOnClickListener {
                if (firstNumber.isNotEmpty()) {
                    binding.tvFirstNumber.visibility = View.GONE
                    binding.tvSecondNumber.visibility = View.VISIBLE
                    operation = Constants.TIMES
                }else {
                    showToast()
                }
            }
            btDivision.setOnClickListener {
                if (firstNumber.isNotEmpty()) {
                    binding.tvFirstNumber.visibility = View.GONE
                    binding.tvSecondNumber.visibility = View.VISIBLE
                    operation = Constants.DIVISION
                }else {
                    showToast()
                }
            }
            btPercentage.setOnClickListener {
                if (firstNumber.isNotEmpty()) {
                    binding.tvFirstNumber.visibility = View.GONE
                    binding.tvSecondNumber.visibility = View.VISIBLE
                    operation = Constants.PERCENTAGE
                }else {
                    showToast()
                }
            }
            btExponentiation.setOnClickListener {
                if (firstNumber.isNotEmpty()) {
                    binding.tvFirstNumber.visibility = View.GONE
                    binding.tvSecondNumber.visibility = View.VISIBLE
                    operation = Constants.EXPONENTIATION
                }else {
                    showToast()
                }
            }
        }
    }

    private fun showToast() {
        Toast.makeText(this, "You should choose a operation!", Toast.LENGTH_LONG).show()
        firstLogInCpp("Error!")
    }

    private external fun stringFromJNI(number: String): String

    private external fun calculateAdd(number: String, operador: String): Int

    private external fun calculateMinus(number: String, operador: String): Int

    private external fun calculateTimes(number: String, operador: String): Int

    private external fun calculateDivision(number: String, operador: String): Double

    private external fun calculateExponentiation(number: String, operador: String): Int

    private external fun calculatePercentage(number: String, operador: String): Double

    private external fun firstLogInCpp(text: String)

    private external fun concatenateNumbers(currentNumber: String, newDigit: String): String


    companion object {
        init {
            System.loadLibrary("jnicalculator")
        }
    }

    private fun printOperationResult(operation: String) {
        if (firstNumber.isNotEmpty() && secondNumber.isNotEmpty()) {
            val number = firstNumber
            val operador = secondNumber

            when (operation) {
                Constants.ADD -> binding.tvCalculateResult.text =
                    "${calculateAdd(number, operador)}"

                Constants.MINUS -> binding.tvCalculateResult.text =
                    "${calculateMinus(number, operador)}"

                Constants.TIMES -> binding.tvCalculateResult.text =
                    "${calculateTimes(number, operador)}"

                Constants.DIVISION -> binding.tvCalculateResult.text =
                    "${calculateDivision(number, operador)}"

                Constants.EXPONENTIATION -> binding.tvCalculateResult.text =
                    "${calculateExponentiation(number, operador)}"

                Constants.PERCENTAGE -> binding.tvCalculateResult.text =
                    "${calculatePercentage(number, operador)}"
            }
        }
    }
}