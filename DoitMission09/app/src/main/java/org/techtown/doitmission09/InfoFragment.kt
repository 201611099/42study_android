package org.techtown.doitmission09

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_info.view.*
import java.text.SimpleDateFormat
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [InfoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InfoFragment : Fragment() {
    // TODO: Rename and change types of parameters
//    private var param1: String? = null
//    private var param2: String? = null
    lateinit var dateString: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_info, container, false)
        rootView.btnBirth.text = SimpleDateFormat("yyyy-MM-dd", Locale("ko", "KR")).format(Date(System.currentTimeMillis()))
        rootView.btnBirth.setOnClickListener {
            val calendar = Calendar.getInstance()
            // https://taetoungs-branch.tistory.com/87
            val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                dateString = "${year}-"
                if (month + 1 < 10)
                    dateString += "0${month + 1}-"
                else
                    dateString += "${month + 1}-"
                if (dayOfMonth < 10)
                    dateString += "0${dayOfMonth}"
                else
                    dateString += "${dateString}"
                rootView.btnBirth.text = dateString
            }
            DatePickerDialog(requireContext(), dateSetListener, calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show()
        }
        rootView.btnSave.setOnClickListener {
            val info: String = "이름: " + rootView.inputName.text.toString() +
                             ", 나이: " + rootView.inputAge.text.toString() +
                             ", 생년월일: " + rootView.btnBirth.text.toString()
            Toast.makeText(context, info, Toast.LENGTH_LONG).show()
        }
        return rootView
    }
//
//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment InfoFragment.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            InfoFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }
}