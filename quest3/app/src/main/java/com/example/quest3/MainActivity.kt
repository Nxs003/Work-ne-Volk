fun main() {
    val str = "…Вновь я посетил\n" +
            "Тот уголок земли, где я провел\n" +
            "Изгнанником два года незаметных."

    val uppercaseStr = str.toUpperCase()
    println(uppercaseStr)

    val lowercaseStr = str.toLowerCase()
    println(lowercaseStr)

    val trimmedStr = str.trim()
    println(trimmedStr)

    val parts = str.split(",")
    println(parts)

    val replacedStr = str.replace("Kotlin", "Java")
    println(replacedStr)

    val a = 20
    val b = 10
    val c = 25

    println(a * b * c - a * c / b)

    val name = "Никита"
    val age = 20

    val message = "Меня зовут $name и мне $age лет."
    println(message)

    val d: Int = 5
    val e: Long = d.toLong()

    val f: Double = 3.14
    val g: Int = f.toInt()

    val v: Int = 10
    val m: String = v.toString()

    val i: String = "5"
    val x: Int = i.toInt()
}
    fun main1() {

        val numbers = arrayOf(100, 200, 300, 400, 500)
        println(numbers[0])
        println(numbers[2])
        println(numbers.size)
        println(numbers.sum())
    }
fun addNumbers(a: Int, b: Int): Int {
    return a + b
}

fun main3() {
    val num1 = 5
    val num2 = 10
    val sum = addNumbers(num1, num2)

    println("Сумма чисел $num1 и $num2 равна $sum")
}







