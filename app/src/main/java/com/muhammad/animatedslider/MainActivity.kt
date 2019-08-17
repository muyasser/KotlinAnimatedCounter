package com.muhammad.animatedslider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val initialTextViewTranslation = textview_progress.translationY

        var textViewText = textview_progress.text.toString().toInt()

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textview_progress.text = progress.toString()

                val translationDistance = (initialTextViewTranslation + progress * resources.getDimension(R.dimen.text_anim_step) * -1)

                textview_progress.animate().translationY(translationDistance)

                if(!fromUser) {
                    textview_progress.animate().setDuration(500).rotationBy(360f)
                        .translationY(initialTextViewTranslation)
                }




            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })

        button_reset.setOnClickListener(View.OnClickListener {
            seekBar.progress = 0



        })
    }
}
