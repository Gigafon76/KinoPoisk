package ru.jay.skillcinema.presentation.adapters.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.jay.skillcinema.R
import ru.jay.skillcinema.databinding.ImageItemBinding
import ru.jay.skillcinema.data.entity.retrofit.GalleryPicture

open class GalleryLimitedAdapter :
    ListAdapter<GalleryPicture, GalleryHolder>(GalleryDiffUtilCallBack()) {

    companion object {
        private const val NUM_OF_PHOTOS = 20
    }

    var onItemClick: ((Int) -> Unit)? = null

    override fun submitList(list: List<GalleryPicture?>?) {
        if ((list?.size ?: 0) >= NUM_OF_PHOTOS) super.submitList(list?.take(NUM_OF_PHOTOS))
        else super.submitList(list)
    }

    override fun onBindViewHolder(holder: GalleryHolder, position: Int) {
        val item = getItem(position)
        with(holder.binding) {
            item.let {
                Glide.with(poster.context)
                    .load(it?.previewUrl)
                    .placeholder(R.drawable.no_poster)
                    .into(poster)
            }
            root.setOnClickListener {
                item?.let {
                    onItemClick?.invoke(position)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryHolder {
        return GalleryHolder(
            ImageItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}

class GalleryDiffUtilCallBack : DiffUtil.ItemCallback<GalleryPicture>() {

    override fun areItemsTheSame(oldItem: GalleryPicture, newItem: GalleryPicture): Boolean =
        oldItem.imageUrl == newItem.imageUrl

    override fun areContentsTheSame(oldItem: GalleryPicture, newItem: GalleryPicture): Boolean =
        oldItem.imageUrl == newItem.imageUrl
}

class GalleryHolder(val binding: ImageItemBinding) : RecyclerView.ViewHolder(binding.root)
