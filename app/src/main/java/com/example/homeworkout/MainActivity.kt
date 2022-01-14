package com.example.homeworkout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    private val dataKnee = ArrayList<Int>()//0 1 2 ....
    private val dataPlank = ArrayList<Int>()
    private val dataClimb = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Isi progress bar secara penuh
        dataKnee.add(100)//0

        dataPlank.add(100)//0

        dataClimb.add(100)//0

        //declare setiap button apabila di click
        val btnKnee = findViewById<Button>(R.id.btnKnee)
        val btnPlank = findViewById<Button>(R.id.btnPlank)
        val btnClimb = findViewById<Button>(R.id.btnMountainClimber)

        //
        btnKnee.setOnClickListener(View.OnClickListener {
            onButton("knee")
        })
        btnPlank.setOnClickListener(View.OnClickListener {
            onButton("plank")
        })
        btnClimb.setOnClickListener(View.OnClickListener {
            onButton("climb")
        })
        //=======-----------===========----------======-----------====

        //Image button kiri
        val btnImgKnee = findViewById<ImageButton>(R.id.ibHighKnee)
        val btnImgPlank = findViewById<ImageButton>(R.id.ibPlank)
        val btnImgClimb = findViewById<ImageButton>(R.id.ibMountainClimber)

        btnImgKnee.setOnClickListener(View.OnClickListener{
            val intent = Intent(this,Knee_desc::class.java).apply{
            }
            startActivity(intent)
        })
        btnImgPlank.setOnClickListener(View.OnClickListener{
            val intent = Intent(this,Plank_desc::class.java).apply{
            }
            startActivity(intent)
        })
        btnImgClimb.setOnClickListener(View.OnClickListener{
            val intent = Intent(this,M_Climb_desc::class.java).apply{
            }
            startActivity(intent)
        })


    }

    private fun onButton(name: String){
        val imageViewer = findViewById<ImageView>(R.id.ivImage)
        imageViewer.setVisibility(View.GONE)


        if(name=="knee"){

            imageViewer.setImageResource(R.drawable.high_knee_man)
            imageViewer.setVisibility(View.VISIBLE)

            updateKnee(this.dataKnee.get(0))

        } else if (name=="plank"){

            imageViewer.setImageResource(R.drawable.plank_1)
            imageViewer.setVisibility(View.VISIBLE)

            updatePlank(this.dataPlank.get(0))


        } else if (name=="climb"){

            imageViewer.setImageResource(R.drawable.mountain_climber3)
            imageViewer.setVisibility(View.VISIBLE)

            updateClimb(this.dataClimb.get(0))
        }

    }

    fun updateKnee(time:Int){


        val pbKnee=findViewById<ProgressBar>(R.id.pbHighKnee)
        pbKnee.setVisibility(View.VISIBLE)
        //----------
        val pbPlank=findViewById<ProgressBar>(R.id.pbPlank)
        pbPlank.setVisibility(View.INVISIBLE)
        //----------
        val pbClimb=findViewById<ProgressBar>(R.id.pbMClimber)
        pbClimb.setVisibility(View.INVISIBLE)
        //--------
        pbKnee.progress=time



        Thread(Runnable {
            var i = 0
            while (i <= time){
                i+=1
                pbKnee.progress=i
                try {//30 sec
                    Thread.sleep(300)
                } catch (e: InterruptedException){
                    e.printStackTrace()
                }
            }
            pbKnee.progress = 0
        }).start()


    }

    fun updatePlank(time:Int){
        val pbKnee=findViewById<ProgressBar>(R.id.pbHighKnee)
        pbKnee.setVisibility(View.INVISIBLE)
        //----------PLaaannnnnkkkkkk
        val pbPlank=findViewById<ProgressBar>(R.id.pbPlank)
        pbPlank.setVisibility(View.VISIBLE)
        //----------
        val pbClimb=findViewById<ProgressBar>(R.id.pbMClimber)
        pbClimb.setVisibility(View.INVISIBLE)
        //--------
        pbPlank.progress=time

        Thread(Runnable {
            var i = 0
            while (i <= time){
                i+=1
                pbPlank.progress=i
                try {//30 sec
                    Thread.sleep(200)
                } catch (e: InterruptedException){
                    e.printStackTrace()
                }
            }
            pbPlank.progress = 0
        }).start()
    }

    fun updateClimb(time:Int){
        val pbKnee=findViewById<ProgressBar>(R.id.pbHighKnee)
        pbKnee.setVisibility(View.INVISIBLE)
        //----------PLaaannnnnkkkkkk
        val pbPlank=findViewById<ProgressBar>(R.id.pbPlank)
        pbPlank.setVisibility(View.INVISIBLE)
        //----------
        val pbClimb=findViewById<ProgressBar>(R.id.pbMClimber)
        pbClimb.setVisibility(View.VISIBLE)
        //--------
        pbClimb.progress=time


        Thread(Runnable {

            var i = 0
            while (i <= time){
                i+=1
                pbClimb.progress=i
                try {//30 sec
                    Thread.sleep(150)
                } catch (e: InterruptedException){
                    e.printStackTrace()
                }
            }
            pbClimb.progress=0
        }).start()
    }
}