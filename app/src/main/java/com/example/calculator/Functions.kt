package com.example.calculator

object Functions {
    object Length {
        // Position in the entry
        private const val MILLIMETER = 0
        private const val CENTIMETER = 1
        private const val DECIMETER = 2
        private const val METER = 3
        private const val KILOMETER = 4
        private const val INCH = 5
        private const val FOOT = 6
        private const val YARD = 7
        private const val MILE = 8

        // Constants to metres
        private const val TO_MILLIMETER = 0.001
        private const val TO_CENTIMETER = 0.01
        private const val TO_DECIMETER = 0.1
        private const val TO_METER = 1.0
        private const val TO_KILOMETER = 1000.0
        private const val TO_INCH = 0.0254
        private const val TO_FOOT = 0.3048
        private const val TO_YARD = 0.9144
        private const val TO_MILES = 1609.344

        private fun inMetres(q: Int): Double {
            return when (q) {
                MILLIMETER -> TO_MILLIMETER
                CENTIMETER -> TO_CENTIMETER
                DECIMETER -> TO_DECIMETER
                METER -> TO_METER
                KILOMETER -> TO_KILOMETER
                INCH -> TO_INCH
                FOOT -> TO_FOOT
                YARD -> TO_YARD
                MILE -> TO_MILES
                else -> 0.0
            }
        }

        private fun toMetres(q: Int): Double {
            return 1 / inMetres(q)
        }

        fun count(firstLength: Int, secondLength: Int, number: Double): Double {
            if (firstLength == secondLength) return number
            return number * inMetres(firstLength) * toMetres(secondLength)
        }


    }

    object Volume {
        // Position in the entry
        const val MILLILITRE = 0
        const val LITRE = 1
        const val PINT = 2
        const val GALLON = 3
        const val BARREL = 4

        // Constants to litre
        private const val TO_MILLILITRE = 0.001
        private const val TO_LITRE = 1.0
        private const val TO_PINT = 1.76
        private const val TO_GALLON = 0.22
        private const val TO_BARREL = 0.008648

        private fun inLitre(q: Int): Double {
            return when (q) {
                MILLILITRE -> TO_MILLILITRE
                LITRE -> TO_LITRE
                PINT -> TO_PINT
                GALLON -> TO_GALLON
                BARREL -> TO_BARREL
                else -> 0.0
            }
        }

        private fun toLitre(q: Int): Double {
            return 1 / inLitre(q)
        }

        fun count(firstVolume: Int, secondVolume: Int, number: Double): Double {
            if (firstVolume == secondVolume) return number
            return number * inLitre(firstVolume) * toLitre(secondVolume)
        }
    }

    object Mass {
        // Position in the entry
        private const val MICROGRAMS = 0
        private const val MILLIGRAMS = 1
        private const val GRAMS = 2
        private const val KILOGRAMS = 3
        private const val CENTNER = 4
        private const val TON = 5
        private const val POUND = 6
        private const val OUNCE = 7

        // Constants to kilograms
        private const val TO_MICROGRAMS = 0.000000001
        private const val TO_MILLIGRAMS = 0.000001
        private const val TO_GRAMS = 0.001
        private const val TO_KILOGRAMS = 1.0
        private const val TO_CENTNER = 100.0
        private const val TO_TON = 1000.0
        private const val TO_POUND = 0.45359236
        private const val TO_OUNCE = 0.0283

        private fun inKilograms(q: Int): Double {
            return when (q) {
                MICROGRAMS -> TO_MICROGRAMS
                MILLIGRAMS -> TO_MILLIGRAMS
                GRAMS -> TO_GRAMS
                KILOGRAMS -> TO_KILOGRAMS
                CENTNER -> TO_CENTNER
                TON -> TO_TON
                POUND -> TO_POUND
                OUNCE -> TO_OUNCE
                else -> 0.0
            }
        }

        private fun toKilograms(q: Int): Double {
            return 1 / inKilograms(q)
        }

        fun count(firstMass: Int, secondMass: Int, number: Double): Double {
            return number * inKilograms(firstMass) * toKilograms(secondMass)
        }
    }

    object Area {
        // Position in the entry
        private const val SQ_MILLIMETER = 0
        private const val SQ_CENTIMETER = 1
        private const val SQ_DECIMETER = 2
        private const val SQ_METER = 3
        private const val SQ_KILOMETER = 4
        private const val SQ_INCH = 5
        private const val SQ_FOOT = 6
        private const val SQ_YARD = 7
        private const val SQ_MILE = 8
        private const val AR = 9
        private  const val HECTARE = 10
        private const val ACRE = 11

        // Constants to sq.Metre
        private const val TO_SQ_MILLIMETER = 0.000001
        private const val TO_SQ_CENTIMETER = 0.0001
        private const val TO_SQ_DECIMETER = 0.01
        private const val TO_SQ_METER = 1.0
        private const val TO_SQ_KILOMETER = 1000000.0
        private const val TO_SQ_INCH = 0.000645
        private const val TO_SQ_FOOT = 0.092903
        private const val TO_SQ_YARD = 0.836127
        private const val TO_SQ_MILES = 2589988.0
        private const val TO_AR = 100.0
        private const val TO_HECTARE = 10000.0
        private const val TO_ACRE = 4046.9

        private fun inSqMeter(q: Int): Double {
            return when (q) {
                SQ_MILLIMETER -> TO_SQ_MILLIMETER
                SQ_CENTIMETER -> TO_SQ_CENTIMETER
                SQ_DECIMETER -> TO_SQ_DECIMETER
                SQ_METER -> TO_SQ_METER
                SQ_KILOMETER -> TO_SQ_KILOMETER
                SQ_INCH -> TO_SQ_INCH
                SQ_FOOT -> TO_SQ_FOOT
                SQ_YARD -> TO_SQ_YARD
                SQ_MILE -> TO_SQ_MILES
                AR -> TO_AR
                HECTARE -> TO_HECTARE
                ACRE -> TO_ACRE
                else -> 0.0
            }
        }

        private fun toSqMeter(q: Int): Double {
            return 1 / inSqMeter(q)
        }

        fun count(firstArea: Int, secondArea: Int, number: Double): Double {
            return number * inSqMeter(firstArea) * toSqMeter(secondArea)
        }
    }

    object NumberSystem {
        // Position in the entry
        private const val BINARY = 0
        private const val OCTAL = 1
        private const val DECIMAL = 2
        private const val HEXADECIMAL = 3

        private fun toDecimal(base: Int, number: Double): Double {
            return when (base) {
                2 -> number.toInt().toString().toInt(base).toDouble()
                8 -> number.toInt().toString().toInt(base).toDouble()
                16 -> number.toInt().toString().toInt(base).toDouble()
                else -> number
            }
        }

        private fun fromDecimal(base: Int, number: Double): Double {
            return when (base) {
                2 -> Integer.toBinaryString(number.toInt()).toDouble()
                8 -> Integer.toOctalString(number.toInt()).toDouble()
                16 -> Integer.toHexString(number.toInt()).toDouble()
                else -> number
            }
        }

        fun count(firstNumber: Int, secondNumber: Int, number: Double): Double {
            if (firstNumber == secondNumber) return number
            when (firstNumber) {
                BINARY -> when (secondNumber) {
                    OCTAL -> return toDecimal(BINARY, number) * fromDecimal(OCTAL, number)
                    DECIMAL -> return toDecimal(BINARY, number) * fromDecimal(DECIMAL, number)
                    HEXADECIMAL -> return toDecimal(BINARY, number) * fromDecimal(HEXADECIMAL, number)
                }
                OCTAL -> when (secondNumber) {
                    BINARY -> return toDecimal(OCTAL, number) * fromDecimal(BINARY, number)
                    DECIMAL -> return toDecimal(OCTAL, number) * fromDecimal(DECIMAL, number)
                    HEXADECIMAL -> return toDecimal(OCTAL, number) * fromDecimal(HEXADECIMAL, number)
                }
                DECIMAL -> when (secondNumber) {
                    BINARY -> return toDecimal(DECIMAL, number) * fromDecimal(BINARY, number)
                    OCTAL -> return toDecimal(DECIMAL, number) * fromDecimal(OCTAL, number)
                    HEXADECIMAL -> return toDecimal(DECIMAL, number) * fromDecimal(HEXADECIMAL, number)
                }
                HEXADECIMAL -> when (secondNumber) {
                    BINARY -> return toDecimal(HEXADECIMAL, number) * fromDecimal(BINARY, number)
                    OCTAL -> return toDecimal(HEXADECIMAL, number) * fromDecimal(OCTAL, number)
                    DECIMAL -> return toDecimal(HEXADECIMAL, number) * fromDecimal(DECIMAL, number)
                }
                }
            return 0.0
        }
    }
}
