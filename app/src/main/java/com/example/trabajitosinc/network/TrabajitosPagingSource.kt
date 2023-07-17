package com.example.trabajitosinc.network

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.trabajitosinc.data.models.PortfolioModel
import com.example.trabajitosinc.network.dto.portfolio.findPortfolioByCategoryId.listFindCById.FindPortfolioByCategoryIdLitst
import com.example.trabajitosinc.network.retrofit.RetrofitInstance
import retrofit2.HttpException
import java.io.IOException

class TrabajitosPagingSource(private val portfolioService: RetrofitInstance):
    PagingSource<Int, FindPortfolioByCategoryIdLitst>() {


    override fun getRefreshKey(state: PagingState<Int, FindPortfolioByCategoryIdLitst>): Int? {
        val pageSize = state.config.pageSize
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(pageSize) ?: anchorPage?.nextKey?.minus(pageSize)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, FindPortfolioByCategoryIdLitst> {
        return try {
            val identifier = params.key?: ""
            val page = params.key?: 0
            val findPortfolioByCatId = portfolioService.findPortfolioCatTEST(identifier as String, page)
            LoadResult.Page(
                data = findPortfolioByCatId.docs,
                nextKey = null,
                prevKey = null
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

}
