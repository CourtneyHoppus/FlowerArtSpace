package com.example.flowerartspace.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Flower(
    @StringRes val nameResourceId: Int,
    @StringRes val lifeCycleResourceId: Int,
    @DrawableRes val imageResourceId: Int
)
