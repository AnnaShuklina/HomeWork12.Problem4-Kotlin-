fun main() {
//    println("Введите число от 0 до 1000") - из-за вывода этой строки падают тесты, они начинают сравнивать с этой строкой
    val input = readLine()
    val number = input?.toIntOrNull()

    if (number == null) {
        println("Вы ввели символы вместо числа")
        return
    }

    if (number < 0 || number > 1000) {
        println("Вы ввели некорректное число не из диапазона от 0 до 1000")
        return
    }

    val units = arrayOf("", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять")
    val tens = arrayOf(
            "",
            "",
            "двадцать",
            "тридцать",
            "сорок",
            "пятьдесят",
            "шестьдесят",
            "семьдесят",
            "восемьдесят",
            "девяносто"
    )
    val hundreds = arrayOf(
            "",
            "сто",
            "двести",
            "триста",
            "четыреста",
            "пятьсот",
            "шестьсот",
            "семьсот",
            "восемьсот",
            "девятьсот"
    )
    val exceptions = mapOf(
            10 to "десять", 11 to "одиннадцать", 12 to "двенадцать",
            13 to "тринадцать", 14 to "четырнадцать", 15 to "пятнадцать",
            16 to "шестнадцать", 17 to "семнадцать", 18 to "восемнадцать",
            19 to "девятнадцать"
    )

    val result = when (number) {
            0 -> "ноль"
            in 1..9 -> units[number]
            in 10..19 -> exceptions[number]
            in 20..99 -> "${tens[number / 10]} ${units[number % 10]}"
            in 100..999 -> "${hundreds[number / 100]} ${
                if (number % 100 != 0) {
                    when (number % 100) {
                        in 1..9 -> "${units[number % 10]}"
                        in 10..19 -> "${exceptions[number % 100]}"
                        in 20..99 -> "${tens[(number % 100) / 10]} ${units[number % 10]}"
                        else -> ""
                    }
                } else ""
            }"

            else -> "тысяча"
        }

        println(result)
    }
