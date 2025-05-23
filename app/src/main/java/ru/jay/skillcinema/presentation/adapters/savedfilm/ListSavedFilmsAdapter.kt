package ru.jay.skillcinema.presentation.adapters.savedfilm

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ru.jay.skillcinema.R
import ru.jay.skillcinema.presentation.adapters.viewholders.FilmsListHolder

class ListSavedFilmsAdapter : SavedFilmAdapter() {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (position == itemCount - 1) (holder as FilmsListHolder).binding.root.visibility = View.GONE
        super.onBindViewHolder(holder, position)
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.movie_item_vertical
    }

}