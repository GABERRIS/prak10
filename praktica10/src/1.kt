fun printNumber(n: Int): List<Int> {
    // Создаем пустой список, который будет содержать числа.
    val numbers = mutableListOf<Int>()

    // Проверяем, не равно ли число нулю.
    if (n == 0) {
        // Если равно, возвращаем пустой список.
        return numbers
    }

    // Если число не равно нулю, добавляем числа в список от n до 1.
    for (i in n downTo 1) {
        numbers.add(i)
    }

    // Возвращаем список.
    return numbers
}

fun main() {
    println(printNumber(0)) // []
    println(printNumber(2)) // [2, 1]
    println(printNumber(5)) // [5, 4, 3, 2, 1]
}