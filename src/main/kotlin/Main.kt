import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

/**
 * The following code sample is deserialising a simple tree structured from JSON.
 * You need to read through it, ask as many questions as you need to, then answer some questions on it,
 * followed by a doing some simple pair prograaming tasks on it.
 *
 *
 * Questions/Tasks:
 *
 * 1. Are there any flaws with this tree structure and how would you change it?
 * 2. Implement the search function, so that a user can find a category by name.
 * 2a. Looking at the search function are you able to determine the space complexity and is there any way you'd improve it?
 * 3. How would you unit test this?
 * 4. With each search result, we also want to include a path of Node Ids to the response.
 *  If time, add this to the implementation, otherwise talk through it.
 *
 */

@OptIn(ExperimentalSerializationApi::class)
private fun main() {
    val categoriesString = getResourceAsText("categories.json")
    requireNotNull(categoriesString)

    val json = Json {
        ignoreUnknownKeys = true
        explicitNulls = false
    }

    val tree = json.decodeFromString<TreeNode>(categoriesString)

    println(tree)
}

/**
 * Search the tree and return a list of TreeNodes that match the search term
 *
 * @param tree: This should be a root node of the Tree
 * @param searchTerm: The term the user has searched for
 * @return A list of TreeNodes where the name partially matches the SearchTerm
 */
fun search(tree: TreeNode, searchTerm: String): List<TreeNode> {
    return emptyList()
}

@Serializable
data class TreeNode(val id: Long, val name: String, val parent: Long?, val children: List<TreeNode>?)

fun getResourceAsText(path: String): String? =
    object {}.javaClass.getResource(path)?.readText()

