package mksnkv.nets.utilities

import kotlin.random.Random

object StringRandomizer {

    const val RANDOM_STRING_SOURCE =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ_" +
                    "=-+0123456789zxcvbnm,./;lkjh" +
                    "gfdsaqwertyuiop[]ячсмитьбюфы" +
                    "вапролджэйцукенгшщзхъйЁЙЦУКЕ" +
                    "НГШЩЗХЪФЫВАПРОЛДЖЭЯЧСМИТЬБЮ"

    fun generateRandomString(lenght: Int): String {
        val sequence = sequence {
            yieldAll(generateSequence { Random.nextInt(RANDOM_STRING_SOURCE.length) })
        }
        return sequence
                .take(lenght)
                .map(RANDOM_STRING_SOURCE::get)
                .joinToString("")
    }

}
