package sim.coder.tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import sim.coder.tablayout.fragment.TabFragment


lateinit var tabLayout: TabLayout
lateinit var tabViewPager: ViewPager2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout = findViewById(R.id.tabs)
        tabViewPager = findViewById(R.id.viewPager)




        tabViewPager.adapter  = object : FragmentStateAdapter(this){
            override fun getItemCount(): Int {

                return 3
            }

            override fun createFragment(position: Int): Fragment {
                return  when(position){

                    0->TabFragment.newInstance("camera")
                    1->TabFragment.newInstance("chat")
                    2->TabFragment.newInstance("calls")


                    else->TabFragment.newInstance("camera")
                }
            }





        }

        TabLayoutMediator(tabLayout, tabViewPager) {tab, position ->
            tab.text = when (position){
                0 -> "Camera"
                1 -> "Chats"
                2 -> "Calls"

                else -> {
                    null
                }
            }


        }.attach()



        tabLayout.getTabAt(0)!!.setIcon(R.drawable.ic_baseline_camera_alt_24)
        tabLayout.getTabAt(1)!!.setIcon(R.drawable.ic_baseline_chat_24)
        tabLayout.getTabAt(2)!!.setIcon(R.drawable.ic_baseline_call_24)

    }
}