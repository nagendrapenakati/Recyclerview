package com.example.recyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    private lateinit var recyclerView: RecyclerView
    private lateinit var foodList:ArrayList<Food>
    private lateinit var foodAdapter: FoodAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    private fun init()
    {
        recyclerView = binding.recyclerview
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager= LinearLayoutManager(requireContext(),RecyclerView.VERTICAL,false)
        foodList= ArrayList()
        addDataToList()
        foodAdapter=FoodAdapter(foodList)
        recyclerView.adapter=foodAdapter
    }

    private fun addDataToList()
    {
        foodList.add(Food(R.drawable.fooda,"Panner Masala"))
        foodList.add(Food(R.drawable.foodb,"Pizza"))
        foodList.add(Food(R.drawable.fooda,"Dosa"))
        foodList.add(Food(R.drawable.foodb,"Parota"))
        foodList.add(Food(R.drawable.fooda,"Pasta"))
        foodList.add(Food(R.drawable.foodb,"Noodles"))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}