import kotlinx.serialization.json.Json

/**
 * Some helper functions to parse the json
 *
 */
fun getResourceAsText(path: String): String? =
    object {}.javaClass.getResource(path)?.readText()

val categoriesString = getResourceAsText("categories.json")

val json = Json {
    ignoreUnknownKeys = true
    explicitNulls = false
}

val tree = json.decodeFromString<TreeNode>(categoriesString!!)
