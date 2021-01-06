package sim.coder.tablayout.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import sim.coder.tablayout.R
import java.util.*


class TabFragment : Fragment() {

    private lateinit var fragmentTextView:TextView
    private  var fragmentName : String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view = inflater.inflate(R.layout.fragment_tab, container, false)
        fragmentName=arguments?.getSerializable("data")as String
        fragmentTextView= view.findViewById(R.id.fragment_text)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        when (fragmentName){
            "camera" -> {
                fragmentTextView.text="Camera Fragment"
                Toast.makeText(context,"Camera Fragment",Toast.LENGTH_LONG).show()
            }
            "chat" -> {
                fragmentTextView.text="Chat Fragment"
                Toast.makeText(context,"Chat Fragment",Toast.LENGTH_LONG).show()
            }
            "calls" -> {
                fragmentTextView.text="Calls Fragment"
                Toast.makeText(context,"Calls Fragment",Toast.LENGTH_LONG).show()
            }
        }

    }

    companion object {

        @JvmStatic
        fun newInstance(data: String) : TabFragment{
            val args=Bundle().apply {
                putSerializable("data",data)
            }
            return TabFragment().apply {
                arguments=args
            }
        }

    }
}