package m.z.newsapp.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import m.z.newsapp.R
import m.z.newsapp.adapter.BaseListAdapter
import m.z.newsapp.adapter.ListAdapterItem

/**
 * Created by Mongi Zaidi on 09/09/2025.
 */
@BindingAdapter("image_url")
fun loadWebImage(imageView: ImageView, url: String?) {
    Glide.with(imageView.context).load(url).placeholder(R.drawable.ic_news_placeholder)
        .into(imageView)
}

@Suppress("UNCHECKED_CAST")
@BindingAdapter("list_data")
fun listData(recyclerView: RecyclerView, list: List<ListAdapterItem>?) {
    val adapter = recyclerView.adapter as BaseListAdapter<ViewDataBinding, ListAdapterItem>?
    adapter?.updateData(list ?: listOf())
}