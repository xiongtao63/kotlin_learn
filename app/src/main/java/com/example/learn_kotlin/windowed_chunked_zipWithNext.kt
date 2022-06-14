import android.os.Build
import androidx.annotation.RequiresApi

//windowed、chunked、zipWithNext
//用于 Iterable<T> 、 Sequence<T> 与 CharSequence 的新的扩展覆盖了这些应用场景：缓存或批处理
//（ chunked ）、 滑动窗口与计算滑动均值（ windowed ）以及处理成对的后续条目（ zipWithNext ）：

@RequiresApi(Build.VERSION_CODES.N)
fun main() {
    val items = (1..9).map { it * it }

    val chunkedIntoLists = items.chunked(4)
    val points3d = items.chunked(3) { (x, y, z) -> Triple(x, y, z) }
    val windowed = items.windowed(4)
    val slidingAverage = items.windowed(4) { it.average() }
    val pairwiseDifferences = items.zipWithNext { a, b -> b - a }

    println("items: $items\n")
    println("chunked into lists: $chunkedIntoLists")
    println("3D points: $points3d")
    println("windowed by 4: $windowed")
    println("sliding average by 4: $slidingAverage")
    println("pairwise differences: $pairwiseDifferences")


    val items1 = (1..5).toMutableList()
    items1.shuffle()
    println("Shuffled items: $items1")

    items1.replaceAll { it * 2 }
    println("Items doubled: $items1")

    items1.fill(5)
    println("Items filled with 5: $items1")

    bar(null)
    bar("dsfds")
}

fun bar(x: String?) {
    if (!x.isNullOrEmpty()) {
        println("length of '$x' is ${x.length}")
    } // 哇，已经智能转换为非空！
}