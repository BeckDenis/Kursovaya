package com.example.kursovaya.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.kursovaya.R
import kotlinx.android.synthetic.main.fragment_tv.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class TvFragment : Fragment(R.layout.fragment_tv) {

    private val viewModel: TvViewModel by viewModel()
    private val args: TvFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.updateMovieId(args.id)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.run {
            movie.observe(viewLifecycleOwner, Observer {
                tv_poster.insertImageW500(it.poster_path)
                tv_title.text = it.name
                tv_description.text = it.overview
            })
        }
    }


}