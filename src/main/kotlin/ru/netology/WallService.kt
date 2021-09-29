package ru.netology

object WallService {
    private var posts = emptyArray<Post>()

    private var arrayAttachment = emptyArray<Attachment>()

    fun addArrayAttachment(attach: Attachment) {
        arrayAttachment += attach
    }

    fun add(post: Post): Post {
        val newId = if (posts.isEmpty()) 1 else posts.last().id?.plus(1)
        posts += post.copy(id = newId, attachment = arrayAttachment)
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