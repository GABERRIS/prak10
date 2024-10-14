fun main() {
    // Ввод текста для шифрования
    println("Введите текст для шифрования:")
    val text = readLine() ?: ""

    // Ввод ключа (сдвига)
    println("Введите ключ (сдвиг):")
    val shift = readLine()?.toIntOrNull() ?: 0

    // Шифрование текста
    val encryptedText = encryptCaesar(text, shift)

    // Вывод зашифрованного текста
    println("Зашифрованный текст: $encryptedText")

    // Дешифрование зашифрованного текста
    val decryptedText = decryptCaesar(encryptedText, shift)

    // Вывод расшифрованного текста
    println("Расшифрованный текст: $decryptedText")
}

// Функция для шифрования текста с помощью шифра Цезаря
fun encryptCaesar(text: String, shift: Int): String {
    // Создаем пустую строку для хранения зашифрованного текста
    val encryptedText = StringBuilder()

    // Проходим по каждому символу в тексте
    for (char in text) {
        // Если символ - буква
        if (char.isLetter()) {
            // Определяем, является ли символ строчной или прописной буквой
            val isUppercase = char.isUpperCase()

            // Преобразуем символ в числовое значение (A = 0, B = 1, ... , Z = 25)
            var charCode = char.code - if (isUppercase) 'A'.code else 'a'.code

            // Применяем сдвиг
            charCode = (charCode + shift) % 26

            // Преобразуем числовое значение обратно в символ
            val encryptedChar = if (isUppercase) (charCode + 'A'.code).toChar() else (charCode + 'a'.code).toChar()

            // Добавляем зашифрованный символ к строке зашифрованного текста
            encryptedText.append(encryptedChar)
        } else {
            // Если символ не буква, просто добавляем его к строке зашифрованного текста
            encryptedText.append(char)
        }
    }

    // Возвращаем строку зашифрованного текста
    return encryptedText.toString()
}

// Функция для дешифрования текста с помощью шифра Цезаря
fun decryptCaesar(text: String, shift: Int): String {
    // Дешифрование аналогично шифрованию, но сдвиг отрицательный
    return encryptCaesar(text, -shift)
}