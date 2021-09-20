package br.com.brunoti.githubrepositories.data.repositories

import br.com.brunoti.githubrepositories.data.model.Repo
import kotlinx.coroutines.flow.Flow

interface RepoRepository {
    suspend fun listRepositories(user: String): Flow<List<Repo>>
}