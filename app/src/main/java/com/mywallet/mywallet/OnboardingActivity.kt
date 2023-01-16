package com.mywallet.mywallet

import OnboardingAdapter
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.google.android.material.button.MaterialButton


class OnboardingActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var onboardingAdapter: OnboardingAdapter
    private lateinit var layoutOnboardingIndicator: LinearLayout
    private lateinit var buttonOnboardingSkip: MaterialButton
    private lateinit var buttonOnboardingNext: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        layoutOnboardingIndicator = findViewById(R.id.layoutOnboardingIndicator)
        buttonOnboardingSkip = findViewById(R.id.buttonOnBoardingActionSkip)
        buttonOnboardingNext = findViewById(R.id.buttonOnBoardingActionNext)

        setOnboardingItem()

        var onboardingViewPager: ViewPager2 = findViewById(R.id.onboardingViewPager)
        onboardingViewPager.adapter = onboardingAdapter

        setOnboardingIndicator()
        setCurrentOnboardingIndicator(0)

        onboardingViewPager.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentOnboardingIndicator(position)
            }
        })

        buttonOnboardingNext.setOnClickListener {
            if (onboardingViewPager.currentItem + 1 < onboardingAdapter.itemCount) {
                onboardingViewPager.currentItem = onboardingViewPager.currentItem + 1
            } else {
                val i = Intent(this@OnboardingActivity, MainActivity::class.java)
                startActivity(i)
                finish()
            }
        }

        buttonOnboardingSkip.setOnClickListener {
            val i = Intent(this@OnboardingActivity, MainActivity::class.java)
            startActivity(i)
            finish()
        }
    }

    private fun setOnboardingIndicator() {
        val indicators = arrayOfNulls<ImageView>(onboardingAdapter.itemCount)
        val layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT,
        )
        layoutParams.setMargins(8, 0, 8, 0)
        for (i in indicators.indices) {
            indicators[i] = ImageView(applicationContext)
            indicators[i]!!.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext, R.drawable.ic_dot //inactive
                )
            )
            indicators[i]!!.layoutParams = layoutParams
            layoutOnboardingIndicator.addView(indicators[i])
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setCurrentOnboardingIndicator(index: Int) {
        val childCount = layoutOnboardingIndicator.childCount
        for (i in 0 until childCount) {
            val imageView = layoutOnboardingIndicator.getChildAt(i) as ImageView
            if (i == index) {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.ic_dot
                    )
                )
            } else {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.ic_dot_inactive
                    )
                )
            }
        }

//        if (index == onboardingAdapter.itemCount - 1) {
//            buttonOnboardingNext.text = "Get Started"
//            buttonOnboardingSkip.text = "Skip"
//        } else {
            buttonOnboardingNext.text = "Next"
            buttonOnboardingSkip.text = "Skip"
//        }
    }

    private fun setOnboardingItem() {
        val onBoardingItems = ArrayList<OnBoardingItem>();

        val item1 = OnBoardingItem();
        item1.title = "Lorem ipsum"
        item1.description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua"
        item1.image = R.drawable.illustration_1

        val item2 = OnBoardingItem();
        item2.title = "Lorem ipsum dolor sit\n" +
                "amet, consectetur"
        item2.description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua"
        item2.image = R.drawable.illustration_2

        val item3 = OnBoardingItem();
        item3.title = "Lorem ipsum"
        item3.description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua"
        item3.image = R.drawable.illustration_3

        onBoardingItems.add(item1);
        onBoardingItems.add(item2);
        onBoardingItems.add(item3);

        onboardingAdapter = OnboardingAdapter(onBoardingItems);

    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }


}