package com.mikekrysan.module28_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Scene
import android.transition.TransitionInflater
import android.transition.TransitionManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.scene1.*
import kotlinx.android.synthetic.main.scene1.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Програмный способ создания сцены
//        val scene1 = Scene(scene_root, text1)
//        val scene2 = Scene(scene_root, text2)
        //Определение сцены с помощью ресурсов
        val scene1 = Scene.getSceneForLayout(scene_root, R.layout.scene1, this)
        val scene2 = Scene.getSceneForLayout(scene_root, R.layout.scene2, this)
//        scene1.enter()

        //TransitionManager
        //Програмный способ
//        val transitionManager = TransitionManager()
//        transitionManager.transitionTo(scene1)
//        button.setOnClickListener {
//                transitionManager.transitionTo(scene2)
//            }

        //Сделаем так, чтобы при повторном нажатии на кнопку запускалась обратная анимация, которая возвращает начальную сцену
        //Когда зашли на scene1, устанавливаем обработчик нажатия на кнопку, который запустит scene2
//        val transitionManager = TransitionManager()
//        scene1.setEnterAction {
//            scene1.sceneRoot.button.setOnClickListener {
//                transitionManager.transitionTo(scene2)
//            }
//        }
//
//        scene2.setEnterAction {
//            scene2.sceneRoot.button.setOnClickListener {
//                transitionManager.transitionTo(scene1)
//            }
//        }
//        //Запускаем scene1
//        transitionManager.transitionTo(scene1)

        //Определение TransitionManager с помощью ресурсов
        val transitionManager = TransitionInflater.from(this).inflateTransitionManager(R.transition.t_manager, scene_root);
//        transitionManager.transitionTo(scene1)
        scene1.setEnterAction {
            scene1.sceneRoot.button.setOnClickListener {
                transitionManager.transitionTo(scene2)
            }
        }

        scene2.setEnterAction {
            scene1.sceneRoot.button.setOnClickListener {
                transitionManager.transitionTo(scene1)
            }
        }
        transitionManager.transitionTo(scene1)
    }
}