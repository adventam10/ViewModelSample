package com.example.viewmodelsample

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodelsample.databinding.MainFragmentBinding


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModels()
    private lateinit var dataBinding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        dataBinding = MainFragmentBinding.inflate(inflater, container, false).also {
            it.lifecycleOwner = this.viewLifecycleOwner
            it.viewModel = this.viewModel
        }
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.message.observe(viewLifecycleOwner, Observer {
            Log.d("TAG", it)
        })
        viewModel.navigateNextAction.observe(viewLifecycleOwner, EventObserver {
            Log.d("TAG", "Next")
            val intent = Intent(requireContext(), SecondActivity::class.java).apply {
            }
            startActivity(intent)
        })
    }
}
