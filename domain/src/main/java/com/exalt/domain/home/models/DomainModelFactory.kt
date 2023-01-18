package com.exalt.domain.home.models

object DomainModelFactory {
    const val POST_ID = "POST_ID"
    const val POST_TEXT = "POST_TEXT"
    const val POST_IMAGE_URL = "POST_IMAGE_URL"
    const val POST_LINK_URL = "POST_URL"
    const val POST_PUBLISH_DATE = "2020-08-20T23:52:42.504Z"
    const val POST_PUBLISH_DATE_FORMATTED = "20 août 2020 à 23:52:42"
    const val POST_LIKES = 100

    const val OWNER_ID = "OWNER_ID"
    const val OWNER_TITLE = "OWNER_TITLE"
    const val OWNER_FIRST_NAME = "OWNER_FIRST_NAME"
    const val OWNER_LAST_NAME = "OWNER_LAST_NAME"
    const val OWNER_PICTURE_URL = "OWNER_PICTURE_URL"
    const val OWNER_PHONE = "OWNER_PHONE"
    const val OWNER_EMAIL = "OWNER_EMAIL"
    const val OWNER_GENDER_MALE = "male"
    const val OWNER_BIRTHDATE = "20/08/1958"
    const val OWNER_BIRTHDATE_RAW = "1958-08-20T23:52:42.504Z"
    const val OWNER_REGISTER_DATE = "OWNER_REGISTER_DATE"
    const val OWNER_STREET = "5225, Hansemyrveien"
    const val OWNER_CITY = "Vingrom Finnamasrk"
    const val OWNER_STATE = "FinnmAirku"
    const val OWNER_COUNTRY = "Norway"
    const val OWNER_ADDRESS = "5225, Hansemyrveien\nVingrom Finnamasrk - FinnmAirku\nNorway"


    const val COMMENT_ID = "COMMENT_ID"
    const val COMMENT_MESSAGE = "COMMENT_MESSAGE"
    const val COMMENT_PUBLISH_DATE = "2021-08-20"
    const val COMMENT_DURATION = "1 a"

    fun getDefaultPostPreviewModel(
        id: String = POST_ID
    ) = PostPreviewModel(
        id = id,
        text = POST_TEXT,
        imageUrl = POST_IMAGE_URL,
        publishDate = POST_PUBLISH_DATE_FORMATTED,
        owner = getDefaultOwnerPreviewModel(),
    )

    fun getDefaultPostModel(
        id: String = POST_ID
    ) = PostModel(
        id = id,
        text = POST_TEXT,
        imageUrl = POST_IMAGE_URL,
        publishDate = POST_PUBLISH_DATE_FORMATTED,
        likes = POST_LIKES,
        link = POST_LINK_URL,
        tags = listOf("tag1", "tag2", "tag3"),
        owner = getDefaultOwnerPreviewModel(),
    )

    fun getDefaultOwnerPreviewModel() = OwnerPreviewModel(
        id = OWNER_ID,
        name = "$OWNER_FIRST_NAME $OWNER_LAST_NAME",
        pictureUrl = OWNER_PICTURE_URL
    )

    fun getDefaultOwnerModel(
        id: String = OWNER_ID
    ) = OwnerModel(
        id = id,
        name = "$OWNER_FIRST_NAME $OWNER_LAST_NAME",
        pictureUrl = OWNER_PICTURE_URL,
        address = getDefaultLocation(),
        dateOfBirth = OWNER_BIRTHDATE,
        email = OWNER_EMAIL,
        gender = OWNER_GENDER_MALE,
        phone = OWNER_PHONE
    )

    fun getDefaultCommentModel(id: String = COMMENT_ID) = CommentModel(
        id = id,
        owner = getDefaultOwnerPreviewModel(),
        message = COMMENT_MESSAGE,
        post = POST_ID,
        durationFromPublishDate = COMMENT_DURATION
    )
    
    fun getDefaultLocation() =
        LocationModel(
            OWNER_ADDRESS
        )
}