package com.maverick.anmp_week1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.maverick.anmp_week1.databinding.FragmentGameBinding

class GameFragment : Fragment() {
    private var totalScore: Int = 0
    private lateinit var binding: FragmentGameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    fun displayNumbers(){
        binding.firstNumText.text = ((1..99).random()).toString()
        binding.secondNumText.text = ((1..99).random()).toString()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(arguments != null){
            val name = GameFragmentArgs.fromBundle(requireArguments()).playerName
            binding.txtTurn.text = "$name's turn"
            displayNumbers()
        }

        binding.btnSubmit.setOnClickListener {
            var firstNum = binding.firstNumText.text.toString().toInt()
            var secondNum = binding.secondNumText.text.toString().toInt()
            var answer = firstNum + secondNum
            var playerAnswer = binding.answerText.text.toString()
            if (playerAnswer != "" && answer == playerAnswer.toInt()){
                totalScore += 1
                binding.answerText.text?.clear()
                displayNumbers()
            }
            else {
                val action = GameFragmentDirections.actionResultFragment(totalScore)
                Navigation.findNavController(it).navigate(action)
            }

        }

//        binding.btnBack.setOnClickListener {
//            val action = GameFragmentDirections.actionMainFragment()
//            Navigation.findNavController(it).navigate(action)
//        }
    }
}