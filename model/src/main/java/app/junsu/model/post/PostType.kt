package app.junsu.model.post

enum class PostType {
    DEFAULT, CLUB, MAJOR,
    ;
}

fun String.toPost(): PostType {
    return when (this) {
        "DEFAULT" -> PostType.DEFAULT
        "MAJOR" -> PostType.MAJOR
        "CLUB" -> PostType.CLUB
        else -> throw IllegalArgumentException()
    }
}
