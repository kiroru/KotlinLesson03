package jp.kiroru.kotlinlesson03

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import jp.kiroru.kotlinlesson03.databinding.FragmentNaviBinding


class NaviFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() =
            NaviFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    private var listener: Listener? = null

    private var _binding: FragmentNaviBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentNaviBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.switchFragmentButton.setOnClickListener {
            listener?.notifyButtonPress()
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is Listener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement NaviFragment.Listener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface Listener {
        fun notifyButtonPress()
    }

}