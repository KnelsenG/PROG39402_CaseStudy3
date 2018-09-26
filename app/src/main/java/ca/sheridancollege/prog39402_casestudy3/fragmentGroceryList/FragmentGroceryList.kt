package ca.sheridancollege.prog39402_casestudy3.fragmentGroceryList

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import ca.sheridancollege.prog39402_casestudy3.R
import ca.sheridancollege.prog39402_casestudy3.adapters.GroceryItemsListAdapter
import ca.sheridancollege.prog39402_casestudy3.base.BaseFragment
import ca.sheridancollege.prog39402_casestudy3.databinding.FragmentGroceryListBinding
import ca.sheridancollege.prog39402_casestudy3.ext.tutorialShown
import com.getkeepsafe.taptargetview.TapTarget
import com.getkeepsafe.taptargetview.TapTargetView
import javax.inject.Inject


class FragmentGroceryList : BaseFragment() {

    @Inject
    lateinit var prefs: SharedPreferences

    private lateinit var binding: FragmentGroceryListBinding
    private lateinit var viewModel: GroceryListViewModel

    private lateinit var adapter: GroceryItemsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(GroceryListViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentGroceryListBinding.inflate(inflater, container, false)
        binding.vm = viewModel
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        if (!prefs.tutorialShown) {

            TapTargetView.showFor(activity, // `this` is an Activity
                    TapTarget.forView(binding.fabNew, "New Button", "Click to start adding items to the list")
                            // All options below are optional
                            .outerCircleColor(android.R.color.holo_red_dark)
                            .outerCircleAlpha(0.96f)
                            .targetCircleColor(android.R.color.white)
                            .titleTextSize(30)
                            .titleTextColor(android.R.color.white)
                            .descriptionTextSize(20)
                            .descriptionTextColor(android.R.color.holo_red_dark)
                            .textColor(android.R.color.holo_blue_dark)
                            .dimColor(android.R.color.black)
                            .drawShadow(true)
                            .transparentTarget(true)
                            .targetRadius(60),
                    object : TapTargetView.Listener() {
                        override fun onTargetClick(view: TapTargetView) {
                            super.onTargetClick(view)
                            prefs.tutorialShown = true
                        }
                    }
            )

        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        init()
        initObservables()
    }

    private fun init() {

        if (!::adapter.isInitialized) {
            adapter = GroceryItemsListAdapter(viewModel.groceryItemClickListener)
        }

        val layoutManager = activity?.let { LinearLayoutManager(it) }

        binding.apply {
            rvGroceries.layoutManager = layoutManager
            rvGroceries.swapAdapter(adapter, true)
        }

    }

    private fun initObservables() {
        viewModel.apply {

            source.observe(this@FragmentGroceryList, Observer {
                adapter.source = it
                adapter.notifyDataSetChanged()
            })

            groceryItemClickEvent.observe(this@FragmentGroceryList, Observer {
                Toast.makeText(context, "${it.name} is selected", Toast.LENGTH_SHORT).show()
            })

            fabClickEvent.observe(this@FragmentGroceryList, Observer {
                view?.findNavController()?.navigate(R.id.action_groceryListFragment_to_addGroceryItemFragment)
            })

            refresh() //initial load
        }
    }

}
