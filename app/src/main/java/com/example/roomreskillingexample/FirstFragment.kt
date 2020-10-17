package com.example.roomreskillingexample

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.roomreskillingexample.model.TaskEntity
import com.example.roomreskillingexample.viewModel.TaskViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mTaskViewModel : TaskViewModel by viewModels()

        var mTask = TaskEntity(task = "PRIMER ELEMENTO", done = true)
        var mTask2 = TaskEntity(0, "SEGUNDO ELEMENTO", false)
      //  mTaskViewModel.insertOptionOne(mTask)
      //  mTaskViewModel.insertOptionTwo(mTask2)
        mTaskViewModel.deleteAll()
        mTaskViewModel.allTask.observe(viewLifecycleOwner, Observer {
            Log.d("LIST", it.toString())
           // adapter.update(it)
        })

        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }
}