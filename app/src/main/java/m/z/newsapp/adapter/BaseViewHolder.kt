package m.z.newsapp.adapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Mongi Zaidi on 09/09/2025.
 */
class BaseViewHolder<BINDING : ViewDataBinding>(val binder: BINDING) :
    RecyclerView.ViewHolder(binder.root) {
}