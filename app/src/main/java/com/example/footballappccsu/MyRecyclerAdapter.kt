package com.example.footballappccsu

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.search_row_item.view.*

class MyRecyclerAdapter(val context : Context, val list : ArrayList<SearchResults>)
    : RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder>()  {

    var count = 0
    private val TAG = "MyRecyclerAdapter"



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // this is a method to inflate a layout from our xml (row_item.xml) and drop that inside
        // a ViewHolder (returns the holder) similar to how we inflate a fragment. we have to
        // use this method to create the views
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.search_row_item,parent,false)

        Log.d(TAG, "onCreateViewHolder: ${count++}")
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        // tells us how many rows will be in the list
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = list[position]
        Log.d(TAG, "onBindViewHolder: $position")
        holder.bind(currentItem)

        // animations
        //holder.itemView.image_restaurant.animation = AnimationUtils.loadAnimation(context,R.anim.fade_transition_animation)
        holder.itemView.search_row_items.animation = AnimationUtils.loadAnimation(context,R.anim.fade_scale_animations)

    }


    inner class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){



        fun bind (data : SearchResults){
            itemView.tv_text.text           = data.text
            itemView.tv_created_at.text     = data.created_at
            itemView.tv_name.text           = data.user.name
            itemView.tv_screen_name.text    = data.user.handle()
            itemView.tv_retweet.text        = data.retweet_count.toString()
            itemView.tv_likes.text          = data.favorite_count.toString()


            if(data.user.profile_image_url_https.isNotEmpty()){
                Picasso.get().load(data.user.profile_image_url_https)
                    .placeholder(R.drawable.ic_twitter_logo_blue)
                    .fit().centerCrop()
                    .into(itemView.iv_profile)
            }else{
                itemView.iv_profile.setImageResource(R.drawable.ic_twitter_logo_blue)
            }

        }

    }


}