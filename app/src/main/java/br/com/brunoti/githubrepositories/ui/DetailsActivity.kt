package br.com.brunoti.githubrepositories.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.brunoti.githubrepositories.data.model.Repo
import br.com.brunoti.githubrepositories.databinding.ActivityDetailsBinding
import com.bumptech.glide.Glide

class DetailsActivity : AppCompatActivity() {

    private val binding by lazy { ActivityDetailsBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val repository = intent.extras?.getParcelable<Repo>("repository")

        with(binding) {
            tvRepoName.text = repository?.name
            tvRepoDescription.text = repository?.description
            tvRepoLanguage.text = repository?.language ?: ""
            tvRepoCreatedAt.text = repository?.createdAt
            tvRepoUpdatedAt.text = repository?.updatedAt
            chipRepoStar.text = repository?.stargazersCount.toString()
            chipRepoWatchers.text = repository?.watchers.toString()
            chipRepoForksCount.text = repository?.forksCount.toString()
            tvRepoOwner.text = repository?.owner?.login
        }

        Glide.with(binding.root.context)
            .load(repository?.owner?.avatarURL).into(binding.ivOwner)
    }

}