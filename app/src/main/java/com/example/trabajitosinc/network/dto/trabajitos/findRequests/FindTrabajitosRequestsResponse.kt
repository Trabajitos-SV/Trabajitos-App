package com.example.trabajitosinc.network.dto.trabajitos.findRequests

data class FindTrabajitosRequestsResponse(
    val docs: List<tempRequestModel>,
    val totalDocs: Int,
    val limit: Int,
    val totalPages: Int,
    val page: Int,
    val pagingCounter: Int,
    val hasPrevPage: Boolean,
    val hasNextPage: Boolean,
    val prevPage: Int,
    val nextPage: Int
)
