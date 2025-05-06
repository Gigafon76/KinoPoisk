package ru.jay.skillcinema.presentation.viewgroups

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import ru.jay.skillcinema.databinding.AddCollectionButtonBinding

class AddCollectionButton @JvmOverloads constructor(
    context: Context,
    attr: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attr, defStyleAttr) {

    val binding = AddCollectionButtonBinding.inflate(LayoutInflater.from(context))

    init {
        addView(binding.root)
    }
}