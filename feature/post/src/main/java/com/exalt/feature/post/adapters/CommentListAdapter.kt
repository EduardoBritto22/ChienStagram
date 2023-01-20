package com.exalt.feature.post.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.exalt.core.ui.extensions.loadUserImage
import com.exalt.feature.post.R
import com.exalt.feature.post.viewobjects.CommentVO

class CommentListAdapter : ListAdapter<CommentVO, CommentListAdapter.CommentViewHolder>(CommentDiffCallBack()) {
    inner class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(comment: CommentVO) {
            itemView.findViewById<ImageView>(R.id.comment_user_picture).let {

                it.loadUserImage(comment.ownerPictureUri)

                it.setOnClickListener {
                    onUserClick?.invoke(comment.ownerId)
                }
            }
            itemView.findViewById<TextView>(R.id.comment_user_name).text = comment.ownerName
            itemView.findViewById<TextView>(R.id.comment_publish_date).text = comment.publishDate
            itemView.findViewById<TextView>(R.id.comment_text).text = comment.message
        }
    }

    var onUserClick: ((String) -> Unit)? = null

    private class CommentDiffCallBack : DiffUtil.ItemCallback<CommentVO>() {
        /**
         * Called to check whether two objects represent the same item.
         * For example, if your items have unique ids, this method should check their id equality.
         */
        override fun areItemsTheSame(oldItem: CommentVO, newItem: CommentVO) =
            oldItem.id == newItem.id

        /**
         * Called to check whether two items have the same data.
         * For example, if you are using DiffUtil with a RecyclerView.Adapter, you should
         * return whether the items' visual representations are the same.
         */
        override fun areContentsTheSame(oldItem: CommentVO, newItem: CommentVO) =
            oldItem.ownerPictureUri == newItem.ownerPictureUri &&
                    oldItem.ownerName == newItem.ownerName &&
                    oldItem.publishDate == newItem.publishDate &&
                    oldItem.message == newItem.message
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.comment_item, parent, false)
        return CommentViewHolder(itemView)
    }
}
