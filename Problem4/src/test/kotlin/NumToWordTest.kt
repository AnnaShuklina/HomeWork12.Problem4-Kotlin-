import org.junit.Test
import org.junit.Assert.*
import java.io.PrintStream
import java.io.ByteArrayOutputStream
import java.io.ByteArrayInputStream

class NumberToWordsTest {

    @Test
    fun testNumberToWordsZero() {
        val expected = "ноль"
        val input = "0\n"
        val result = getNumberInWords(input)
        assertEquals(expected, result)
    }

    @Test
    fun testNumberToWordsUnits() {
        val expected = "один"
        val input = "1\n"
        val result = getNumberInWords(input)
        assertEquals(expected, result)
    }

    @Test
    fun testNumberToWordsTens() {
        val expected = "сорок пять"
        val input = "45\n"
        val result = getNumberInWords(input)
        assertEquals(expected, result)
    }

    @Test
    fun testNumberToWordsHundreds() {
        val expected = "девятьсот восемьдесят четыре"
        val input = "984\n"
        val result = getNumberInWords(input)
        assertEquals(expected, result)
    }

    @Test
    fun testNumberToWordsExceptions() {
        val expected = "девятнадцать"
        val input = "19\n"
        val result = getNumberInWords(input)
        assertEquals(expected, result)
    }

    @Test
    fun testNumberToWordsOutOfRange() {
        val expected = "Вы ввели некорректное число не из диапазона от 0 до 1000"
        val input = "1001\n"
        val result = getNumberInWords(input)
        assertEquals(expected, result)
    }

    @Test
    fun testNumberToWordsNotANumber() {
        val expected = "Вы ввели символы вместо числа"
        val input = "abc\n"
        val result = getNumberInWords(input)
        assertEquals(expected, result)
    }

    fun getNumberInWords(input: String): String {
        val savedIn = System.`in`
        val savedOut = System.out

        val inputStream = ByteArrayInputStream(input.toByteArray())
        val outputStream = ByteArrayOutputStream()

        System.setIn(inputStream)
        System.setOut(PrintStream(outputStream))

        main()

        System.setIn(savedIn)
        System.setOut(savedOut)

        return outputStream.toString().trim()
    }
}
