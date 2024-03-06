package com.maverick.anmp_week1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.maverick.anmp_week1.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (arguments != null){
            val playerScore = ResultFragmentArgs.fromBundle(requireArguments()).playerScore
            binding.scoreText.text = "Your score is $playerScore"
        }

        binding.btnBack.setOnClickListener {
            val action = ResultFragmentDirections.actionMainFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
}