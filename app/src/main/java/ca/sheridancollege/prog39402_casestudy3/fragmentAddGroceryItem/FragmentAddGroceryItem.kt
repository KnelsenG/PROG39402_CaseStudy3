package ca.sheridancollege.prog39402_casestudy3.fragmentAddGroceryItem

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import ca.sheridancollege.prog39402_casestudy3.base.BaseFragment
import ca.sheridancollege.prog39402_casestudy3.databinding.FragmentAddGroceryItemBinding

class FragmentAddGroceryItem : BaseFragment() {

    private lateinit var binding: FragmentAddGroceryItemBinding
    private lateinit var viewModel: AddGroceryItemViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(AddGroceryItemViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        binding = FragmentAddGroceryItemBinding.inflate(inflater, container, false)
        binding.vm = viewModel

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        init()
        initObservables()
    }

    private fun init() {

        binding.apply {

        }

    }

    private fun initObservables() {
        viewModel.apply {
            saveEventBegin.observe(this@FragmentAddGroceryItem, Observer {
                //view?.findNavController()?.popBackStack()
            })

            saveEventComplete.observe(this@FragmentAddGroceryItem, Observer {
                view?.findNavController()?.popBackStack()
            })
        }
    }

}
