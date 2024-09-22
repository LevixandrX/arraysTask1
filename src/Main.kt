fun main() {
    println("Эта программа создает двумерный массив, заполняемый трехзначными числами, и подсчитывает количество уникальных цифр в массиве.")

    println("Введите количество строк массива:")
    val rows = readlnOrNull()?.toIntOrNull() ?: return println("Ошибка: Введите корректное количество строк.")

    println("Введите количество столбцов массива:")
    val cols = readlnOrNull()?.toIntOrNull() ?: return println("Ошибка: Введите корректное количество столбцов.")

    if (rows <= 0 || cols <= 0) {
        println("Ошибка: Количество строк и столбцов должно быть больше нуля.")
        return
    }

    val matrix = Array(rows) { IntArray(cols) }
    val uniqueDigits = mutableSetOf<Char>()

    var i = 0
    while (i < rows) {
        var j = 0
        while (j < cols) {
            println("Введите трехзначное число для позиции [$i][$j]:")
            val num = readlnOrNull()?.toIntOrNull()

            if (num == null || num < 100 || num > 999) {
                println("Ошибка: Введите корректное трехзначное число.")
                continue
            }

            matrix[i][j] = num
            uniqueDigits.addAll(num.toString().toList())
            j++
        }
        i++
    }

    println("Ваш двумерный массив:")
    for (i in 0 until rows) {
        for (j in 0 until cols) {
            print("${matrix[i][j]}\t")
        }
        println()
    }

    println("В массиве использовано ${uniqueDigits.size} различных цифр.")
}