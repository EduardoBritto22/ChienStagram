package com.exalt.feature.home.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.eXalt.feature.home.R
import com.exalt.core.ui.extensions.loadImage
import com.exalt.core.ui.extensions.loadUserImage
import com.exalt.feature.home.viewobjects.PostPreviewVO

class PostListAdapter : ListAdapter<PostPreviewVO, PostListAdapter.PostViewHolder>(PostDiffCallBack()) {
    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(post: PostPreviewVO) {
            itemView.findViewById<ImageView>(R.id.user_picture).let {
                it.loadUserImage(post.ownerPictureUri)
                it.setOnClickListener {
                    onUserClick?.invoke(post.ownerId)
                }
            }
            itemView.findViewById<TextView>(R.id.user_name).text = post.ownerName
            itemView.findViewById<TextView>(R.id.post_date).text = post.publishDate
            itemView.findViewById<ImageView>(R.id.post_image).let {

                it.loadImage(post.imageUri)

                it.setOnClickListener {
                    onPostClick?.invoke(post.id)
                }
            }
            itemView.findViewById<TextView>(R.id.post_description).text = post.text
        }
    }

    var onUserClick: ((String) -> Unit)? = null
    var onPostClick: ((String) -> Unit)? = null

    private class PostDiffCallBack : DiffUtil.ItemCallback<PostPreviewVO>() {
        /**
         * Called to check whether two objects represent the same item.
         * For example, if your items have unique ids, this method should check their id equality.
         */
        override fun areItemsTheSame(oldItem: PostPreviewVO, newItem: PostPreviewVO) =
            oldItem.id == newItem.id

        /**
         * Called to check whether two items have the same data.
         * For example, if you are using DiffUtil with a RecyclerView.Adapter, you should
         * return whether the items' visual representations are the same.
         */
        override fun areContentsTheSame(oldItem: PostPreviewVO, newItem: PostPreviewVO) =
            oldItem.ownerPictureUri == newItem.ownerPictureUri &&
                    oldItem.ownerName == newItem.ownerName &&
                    oldItem.publishDate == newItem.publishDate &&
                    oldItem.imageUri == newItem.imageUri &&
                    oldItem.text == newItem.text
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.post_item, parent, false)
        return PostViewHolder(itemView)
    }
}
