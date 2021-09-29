package ru.netology

object WallService {
    private var posts = emptyArray<Post>()

    fun add(post: Post): Post {
        posts += if (posts.isEmpty()) post.copy(id = 1)
        else post.copy(id = posts.last().id?.plus(1))
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, element) in posts.withIndex()) {
            if (element.id == post.id) {
                posts[index] = post.copy(id = element.id, date = element.date)
                return true
            }
        }
        return false
    }
}