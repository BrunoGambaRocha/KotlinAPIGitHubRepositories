package br.com.brunoti.githubrepositories.domain

import br.com.brunoti.githubrepositories.core.UseCase
import br.com.brunoti.githubrepositories.data.model.Repo
import kotlinx.coroutines.flow.Flow

class ListUserRepositoriesUseCase : UseCase<String, List<Repo>>() {

    override suspend fun execute(param: String): Flow<List<Repo>> {
        TODO("Not yet implemented")
    }
}