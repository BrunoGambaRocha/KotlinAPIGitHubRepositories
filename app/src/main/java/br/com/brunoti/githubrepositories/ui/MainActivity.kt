package br.com.brunoti.githubrepositories.ui

import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import br.com.brunoti.githubrepositories.R
import br.com.brunoti.githubrepositories.core.createProgressDialog
import br.com.brunoti.githubrepositories.core.hideSoftKeyboard
import br.com.brunoti.githubrepositories.databinding.ActivityMainBinding
import br.com.brunoti.githubrepositories.presentation.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private val viewModel by viewModel<MainViewModel>()
    private val adapter by lazy { RepoListAdapter() }
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.rvRepos.adapter = adapter

        viewModel.getRepoList("BrunoGambaRocha")

        viewModel.repos.observe(this) {
            when (it) {
                MainViewModel.State.Loading -> { }
                is MainViewModel.State.Error -> { }
                is MainViewModel.State.Success -> {
                    adapter.submitList(it.list)
                }
            }

        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        val searchView = menu.findItem(R.id.action_search).actionView as SearchView
        searchView.setOnQueryTextListener(this)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        //Log.e(TAG, "onQueryTextSubmit: $query")   //atalho: loge
        query?.let { viewModel.getRepoList(it) }
        binding.root.hideSoftKeyboard()
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        Log.e(TAG, "onQueryTextChange: $newText")   //atalho: loge
        return false
    }

    companion object {
        private const val TAG = "TAG"
    }

}