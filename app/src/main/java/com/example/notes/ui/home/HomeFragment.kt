package com.example.notes.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.Nota
import com.example.notes.R
import com.example.notes.databinding.FragmentHomeBinding
import com.example.notes.db.DatabaseAndroid
import com.example.notes.views.adapters.RecyAdapter
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /*
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        */
        val binding = FragmentHomeBinding.inflate(layoutInflater)


        with(binding) {
            var viewAdapter: RecyclerView.Adapter<*>
            val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

                val arrayProva = arrayListOf(Nota("nota","23/04/2021","Nota ...."))
                arrayProva.add(Nota("nota2","23/04/2021","notina...."))
                // aggiungere la lista delle note al posto di "ArrayList<Nota>"
//            viewAdapter = RecyAdapter(ArrayList<Nota> , activity)



                viewAdapter = RecyAdapter(arrayProva, activity)

                homeRecyclerView.setHasFixedSize(true)
                homeRecyclerView.layoutManager = layoutManager
                homeRecyclerView.adapter = viewAdapter

            }


        return binding.root
    }
}