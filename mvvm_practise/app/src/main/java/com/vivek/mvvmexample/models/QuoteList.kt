package com.vivek.mvvmexample.models

data class QuoteList(
	val count: Int? = null,
	val totalPages: Int? = null,
	val lastItemIndex: Int? = null,
	val page: Int? = null,
	val totalCount: Int? = null,
	val results: List<ResultsItem?>? = null
)

data class ResultsItem(
	val authorSlug: String? = null,
	val author: String? = null,
	val length: Int? = null,
	val dateModified: String? = null,
	val id: String? = null,
	val content: String? = null,
	val dateAdded: String? = null,
	val tags: List<String?>? = null
)

