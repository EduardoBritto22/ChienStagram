package com.exalt.feature.post.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.exalt.feature.post.R

class TagListAdapter(
    private val tags: List<String>
) : Adapter<TagListAdapter.TagViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.post_tag, parent, false)
        return TagViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return tags.size
    }

    override fun onBindViewHolder(holder: TagViewHolder, position: Int) {
        holder.bind(tags[position])
    }


    inner class TagViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tagTextView: TextView

        init {
            tagTextView = itemView.findViewById(R.id.post_tag)
        }

        fun bind(tagName: String) {
            tagTextView.text = tagName
        }
    }


}