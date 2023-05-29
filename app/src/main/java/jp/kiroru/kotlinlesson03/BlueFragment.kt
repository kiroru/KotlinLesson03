package jp.kiroru.kotlinlesson03

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import jp.kiroru.kotlinlesson03.databinding.FragmentBlueBinding


class BlueFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() =
            BlueFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    private var _binding: FragmentBlueBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBlueBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}