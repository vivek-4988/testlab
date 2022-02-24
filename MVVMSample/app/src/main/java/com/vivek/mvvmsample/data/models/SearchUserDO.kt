package com.vivek.mvvmsample.data.models

data class SearchUserDO(
    val totalCount: Int? = null,
    val incompleteResults: Boolean? = null,
    val items: List<UsersItem?>? = null
)

