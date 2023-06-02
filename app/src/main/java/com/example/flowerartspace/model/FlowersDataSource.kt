package com.example.flowerartspace.model

import com.example.flowerartspace.R

object FlowersList {
    val flowers = listOf(
        Flower(
            nameResourceId = R.string.chrysanthemum,
            lifeCycleResourceId = R.string.perennial,
            imageResourceId = R.drawable.chrysanthemum
        ),
        Flower(
            nameResourceId = R.string.anemone,
            lifeCycleResourceId = R.string.annual,
            imageResourceId = R.drawable.anemone
        ),
        Flower(
            nameResourceId = R.string.carnation,
            lifeCycleResourceId = R.string.annual,
            imageResourceId = R.drawable.carnation
        ),
        Flower(
            nameResourceId = R.string.cherry_blossom,
            lifeCycleResourceId = R.string.perennial,
            imageResourceId = R.drawable.cherry_blossom
        ),
        Flower(
            nameResourceId = R.string.rose,
            lifeCycleResourceId = R.string.perennial,
            imageResourceId = R.drawable.rose
        ),
    )
}
