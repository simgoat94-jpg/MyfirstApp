package ru.keryakov.myfirstapp.adapter

import androidx.recyclerview.widget.RecyclerView
import ru.keryakov.myfirstapp.R
import ru.keryakov.myfirstapp.databinding.CardPostBinding
import ru.keryakov.myfirstapp.dto.Post
import ru.keryakov.myfirstapp.util.FormatUtils

    class PostViewHolder(
        private val binding: CardPostBinding,
        private val onLikeClickListener: (Post) -> Unit,
        private val onShareClickListener: (Post) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(post: Post) {
            binding.apply {
                author.text = post.author
                published.text = post.published
                content.text = post.content

                likeCount.text = FormatUtils.formatCount(post.likes)
                shareCount.text = FormatUtils.formatCount(post.shares)
                viewsCount.text = FormatUtils.formatCount(post.views)

                if (post.likedByMe) like.setImageResource(R.drawable.favorite_border)
                else like.setImageResource(R.drawable.favorite)

                like.setOnClickListener { onLikeClickListener(post) }
                share.setOnClickListener { onShareClickListener(post) }
                menu.setOnClickListener {
                    android.widget.Toast.makeText(
                        itemView.context,
                        "Меню поста ${post.id}",
                        android.widget.Toast.LENGTH_SHORT
                    ).show()
                }
                avatar.setOnClickListener {
                    android.widget.Toast.makeText(
                        itemView.context,
                        "Профиль автора ${post.author}",
                        android.widget.Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }