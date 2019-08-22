package com.lambdaschool.congressfragmentsproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.lambdaschool.congressfragmentsproject.api.CongressDao
import com.lambdaschool.congressfragmentsproject.api.CongressDao.allMembers
import com.lambdaschool.congressfragmentsproject.api.CongresspersonDetails
import com.lambdaschool.congressfragmentsproject.api.CongresspersonOverview
import kotlinx.android.synthetic.main.activity_fragment.*

class FragmentActivity : AppCompatActivity(), CongresspersonOverviewFragment.OnListFragmentInteractionListener {
    override fun onListFragmentInteraction(item: CongresspersonOverview?) {
       Toast.makeText(this, "Fragment interacted + $item", Toast.LENGTH_LONG).show()

        val fragment = DetailFragment()

        val bundle = Bundle()
        bundle.putSerializable(CongressDao.CONGRESS_NUMBER, item.toString())
        fragment.arguments = bundle


        // TODO 21 apply logic to secondary fragment

        if (second_fragment_holder_view == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_fragment_holder_view, fragment)

                .addToBackStack(null)

                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.second_fragment_holder_view, fragment)
                .commit()
        }


    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
    }
}
