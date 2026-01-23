package org.michaelbel.plurals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.michaelbel.plurals.databinding.PluralsFragmentBinding
import kotlin.properties.Delegates

class PluralsFragment: Fragment(R.layout.plurals_fragment) {

    private var _binding: PluralsFragmentBinding? = null
    private val binding get() = _binding!!

    private var count: Int by Delegates.observable(0) { _, _, newValue ->
        binding.textView.text = resources.getQuantityString(R.plurals.days_count, newValue, newValue)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = PluralsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textView.text = resources.getQuantityString(R.plurals.days_count, count, count)

        binding.decreaseButton.setOnClickListener { count-- }
        binding.increaseButton.setOnClickListener { count++ }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
