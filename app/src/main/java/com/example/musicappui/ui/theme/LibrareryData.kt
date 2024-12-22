package com.example.musicappui.ui.theme

import androidx.annotation.DrawableRes
import com.example.musicappui.R

data class Lib(@DrawableRes val icon:Int,val name:String)
    val Libraries= listOf<Lib> (
        Lib(R.drawable.baseline_queue_music_24,"Playlist"),
        Lib(R.drawable.baseline_mic_external_on_24,"Artists"),
        Lib(R.drawable.baseline_album_24,"Albums"),
        Lib(R.drawable.baseline_music_note_24,"Songs"),
        Lib(R.drawable.baseline_priority_high_24,"Genre"),

)
